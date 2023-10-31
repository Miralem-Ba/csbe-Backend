package com.example.demo.auth;

/**
 * Data Transfer Object (DTO) class for user registration.
 * This class represents the data required for a user to register in the system,
 * including the firstname, lastname, username, password, and email.
 */

public class RegistrationDto {

    /** The first name of the user. */

    public String firstName;

    /** The last name of the user. */

    public String lastName;

    /** The username chosen by the user. This should be unique across the system. */

    private String username;

    /** The password chosen by the user. */

    private String password;

    /** The email address of the user. */

    private String email;

    /**
     * Gets the first name of the user.
     *
     * @return the first name of the user.
     */

    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstName the first name to set.
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the user.
     *
     * @return the last name of the user.
     */

    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName the last name to set.
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the username of the user.
     *
     * @return the username of the user.
     */

    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for the user.
     *
     * @param username the username to set.
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password of the user.
     */

    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the user.
     *
     * @param password the password to set.
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the email address of the user.
     *
     * @return the email address of the user.
     */

    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address for the user.
     *
     * @param email the email address to set.
     */

    public void setEmail(String email) {
        this.email = email;
    }
}
