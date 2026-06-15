/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartschool.permit.tubespbo.service;
import com.smartschool.permit.tubespbo.app.UserSession;
import com.smartschool.permit.tubespbo.model.AdminUser;
import com.smartschool.permit.tubespbo.model.StudentPermit;
import com.smartschool.permit.tubespbo.model.enums.PermitType;
import com.smartschool.permit.tubespbo.repository.PermitRepository;
import com.smartschool.permit.tubespbo.util.SchoolUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Doni354
 */
public class PermitService {
    private final PermitRepository permitRepo;

    public PermitService(PermitRepository permitRepo) {
        this.permitRepo = permitRepo;
    }

    public List<StudentPermit> getAllPermits(String schoolId) {
        return permitRepo.getBySchool(schoolId);
    }

    public List<StudentPermit> getPermitsByType(String schoolId, PermitType type) {
        return permitRepo.getByType(schoolId, type);
    }

    public String createPermit(StudentPermit permit) {
        long now = System.currentTimeMillis();
        permit.setTimestamp(now);
        permit.setCreatedAt(com.google.cloud.Timestamp.now());
        permit.setStatus(com.smartschool.permit.tubespbo.model.enums.PermitStatus.PENDING);
        permit.setTahunAjaran(SchoolUtils.getTahunAjaran(now));
        if (permit.getSchoolId() == null || permit.getSchoolId().isEmpty()) {
        permit.setSchoolId(UserSession.getInstance().getSchoolId());
    }
        return permitRepo.create(permit);
    }

    public void updatePermit(String id, StudentPermit permit) {
        permitRepo.update(id, permit.toMap());
    }

    public void deletePermit(String id) {
        permitRepo.delete(id);
    }

    public void approvePermit(String permitId, AdminUser admin) {
        Map<String, Object> approval = new HashMap<>();
        approval.put("status", "APPROVED");
        approval.put("approvedBy", admin.getName());
        approval.put("approvedById", admin.getId());
        approval.put("approvedAt", System.currentTimeMillis());
        approval.put("isSuperAdminApproved", admin.isSuperAdmin());
        
        permitRepo.approvePermit(permitId, approval);
    }

    public List<StudentPermit> filterPermits(List<StudentPermit> permits, String classFilter, String search) {
        List<StudentPermit> filtered = new ArrayList<>();
        for (StudentPermit p : permits) {
            boolean matchesClass = true;
            if (classFilter != null && !classFilter.isEmpty()) {
                matchesClass = p.getClassName() != null && p.getClassName().startsWith(classFilter);
            }
            
            boolean matchesSearch = true;
            if (search != null && !search.isEmpty()) {
                matchesSearch = p.matchesFilter(search);
            }

            if (matchesClass && matchesSearch) {
                filtered.add(p);
            }
        }
        return filtered;
    }
}
