package com.example;

import java.io.*;
import java.sql.*;
import java.util.*;

public class InsecureExample {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb"; // Hardcoded credentials
    private static final String DB_USER = "root";
    private static final String DB_PASS = "password";

    public static void main(String[] args) throws Exception {
        InsecureExample example = new InsecureExample();
        example.loginUser("admin", "admin123");
        example.infiniteLoop(); // Dead code
    }

    public void loginUser(String username, String password) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement stmt = conn.createStatement();
            // 🔥 SQL Injection vulnerability
            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }

            // 🧼 Resource leak: not closing ResultSet, Statement, or Connection
        } catch (SQLException e) {
            e.printStackTrace(); // Code smell: stack trace printed directly
        }
    }

    public void infiniteLoop() {
        // 🐞 Infinite loop (dead code)
        while (true) {
            System.out.println("Running...");
        }
    }

    public void printPasswords(List<String> passwords) {
        for (String pwd : passwords) {
            // 🔐 Security issue: logging sensitive info
            System.out.println("User password: " + pwd);
        }
    }
}