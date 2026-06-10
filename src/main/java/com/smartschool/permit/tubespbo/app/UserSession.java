/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartschool.permit.tubespbo.app;
import com.smartschool.permit.tubespbo.model.AdminUser;
/**
 *
 * @author Doni354
 */
public class UserSession {
    private static UserSession instance;
    private AdminUser currentUser;

    private UserSession() {}

    public static synchronized UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void login(AdminUser user) {
        this.currentUser = user;
    }

    public void logout() {
        this.currentUser = null;
    }

    public AdminUser getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public boolean isSuperAdmin() {
        return currentUser != null && currentUser.isSuperAdmin();
    }

    public String getSchoolId() {
        return currentUser != null ? currentUser.getSchoolId() : null;
    }
}
