package com.example.demo.User;

import jakarta.persistence.*;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(Object firstName) {
    }

    public void setLastName(Object lastName) {
    }

    public void setUserName(Object userName) {
    }

    public void setPassword(String encode) {
    }

    public String getPassword() {
        return null;
    }

    public Object getUserName() {
        return null;
    }

    public User orElseThrow(Object o) {
        return null;
    }

    public boolean isAdmin() {
        return false;
    }
}
