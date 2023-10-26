package com.example.demo.auth;

public class RegistrationDto {

    private String username;
    private String password;
    private String email;

    // Standardkonstruktor
    public RegistrationDto() {
    }

    // Konstruktor mit Parametern
    public RegistrationDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getter- und Setter-Methoden
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getFirstName() {
        return null;
    }

    public Object getLastName() {
        return null;
    }

    public Object getUserName() {
        return null;
    }
}
