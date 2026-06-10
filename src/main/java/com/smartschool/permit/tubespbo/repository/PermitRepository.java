/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartschool.permit.tubespbo.repository;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.smartschool.permit.tubespbo.model.StudentPermit;
import com.smartschool.permit.tubespbo.model.enums.PermitType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Doni354
 */
public class PermitRepository extends BaseRepository<StudentPermit> {

    public PermitRepository() {
        super("permits");
    }

    @Override
    protected StudentPermit toEntity(DocumentSnapshot doc) {
        StudentPermit permit = new StudentPermit();
        permit.fromMap(doc.getData());
        permit.setId(doc.getId());
        return permit;
    }

    public List<StudentPermit> getBySchool(String schoolId) {
        List<StudentPermit> list = new ArrayList<>();
        try {
            QuerySnapshot query = db.collection(collectionName)
                    .whereEqualTo("schoolId", schoolId)
                    .orderBy("timestamp", Query.Direction.DESCENDING)
                    .get().get();
            for (QueryDocumentSnapshot doc : query.getDocuments()) {
                list.add(toEntity(doc));
            }
        } catch (Exception e) {
            System.err.println("Error getBySchool (Permit): " + e.getMessage());
        }
        return list;
    }

    public List<StudentPermit> getByType(String schoolId, PermitType type) {
        List<StudentPermit> list = new ArrayList<>();
        try {
            QuerySnapshot query = db.collection(collectionName)
                    .whereEqualTo("schoolId", schoolId)
                    .whereEqualTo("type", type.name())
                    .orderBy("timestamp", Query.Direction.DESCENDING)
                    .get().get();
            for (QueryDocumentSnapshot doc : query.getDocuments()) {
                list.add(toEntity(doc));
            }
        } catch (Exception e) {
            System.err.println("Error getByType (Permit): " + e.getMessage());
        }
        return list;
    }

    public void approvePermit(String permitId, Map<String, Object> approvalData) {
        update(permitId, approvalData);
    }
}