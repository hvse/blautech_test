package com.blautech.app.DTO;

public class AuthRequest {

    private String email;
    private String password;

    // Getter de email
    public String getEmail() {
        return email;
    }

    // Setter de email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter de password
    public String getPassword() {
        return password;
    }

    // Setter de password
    public void setPassword(String password) {
        this.password = password;
    }
}