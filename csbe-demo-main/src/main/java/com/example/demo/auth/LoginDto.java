package com.example.demo.auth;

import jakarta.validation.constraints.NotBlank;

/**
 * Data Transfer Object (DTO) class for user login credentials.
 * This class represents the data required for a user to login,
 * including the username and password.
 * Both fields are marked as @NotBlank to ensure they are provided during the login process.
 */

public class LoginDto {

    /**
     * The username used for login.
     * This field is validated to ensure it's not blank.
     */

    @NotBlank
    private String userName;

    /**
     * The password used for login.
     * This field is validated to ensure it's not blank.
     */

    @NotBlank
    private String password;

    /**
     * Gets the username.
     *
     * @return the username.
     */

    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username.
     *
     * @param userName the username to set.
     */

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the password.
     *
     * @return the password.
     */

    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the password to set.
     */

    public void setPassword(String password) {
        this.password = password;
    }
}
