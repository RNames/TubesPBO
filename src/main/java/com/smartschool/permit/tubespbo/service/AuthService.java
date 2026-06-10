/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartschool.permit.tubespbo.service;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.smartschool.permit.tubespbo.app.UserSession;
import com.smartschool.permit.tubespbo.model.AdminUser;
import com.smartschool.permit.tubespbo.repository.AdminRepository;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
/**
 *
 * @author Doni354
 */
public class AuthService {
    private final AdminRepository adminRepo;
    private final String API_KEY = "AIzaSyB9L6LOrxcnDZov4xEH522MZEqOtmTXfmg";

    // Dependency Injection via Constructor
    public AuthService(AdminRepository adminRepo) {
        this.adminRepo = adminRepo;
    }

    public AdminUser login(String email, String password) throws Exception {
        String urlStr = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=" + API_KEY;
        
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setDoOutput(true);

        
        JsonObject jsonPayload = new JsonObject();
        jsonPayload.addProperty("email", email);
        jsonPayload.addProperty("password", password);
        jsonPayload.addProperty("returnSecureToken", true);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonPayload.toString().getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int code = conn.getResponseCode();
        if (code != 200) {
            throw new Exception("Email atau password salah, cuy!");
        }
        
        String responseBody;
        try (Scanner scanner = new Scanner(conn.getInputStream(), StandardCharsets.UTF_8.name())) {
            responseBody = scanner.useDelimiter("\\A").next();
        }


        JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();
        String uid = jsonResponse.get("localId").getAsString();


        AdminUser adminUser = adminRepo.getByUid(uid);
        if (adminUser == null) {
            throw new Exception("Akun terdaftar di Auth, tapi datanya ga ada di Firestore (bukan admin)!");
        }

        UserSession.getInstance().login(adminUser);
        return adminUser;
    }

    public void logout() {
        UserSession.getInstance().logout();
    }
}
