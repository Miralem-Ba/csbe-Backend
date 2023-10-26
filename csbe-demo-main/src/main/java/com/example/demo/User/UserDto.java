package com.example.demo.User;

import jakarta.validation.constraints.NotBlank;

public class UserDto {
    private int id;

    @NotBlank
    private String lastName;

    @NotBlank
    private String firstName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}