package com.example.demo.User;

/**
 * A Data Transfer Object (DTO) representing a User entity.
 * <p>
 * This DTO is typically used to transfer data between the application layers
 * without exposing the entire User domain model. It captures a subset of information
 * about the User and provides getters and setters for that information.
 * </p>
 */

public class UserDto {

    /** Unique identifier for the user. */

    private int userId;

    /** Name of the user. */

    private String Name;

    /** First name of the user. */

    private String firstName;

    /** Description about the user. */

    private String description;

    /** Image URL or path associated with the user. */

    private String image;

    /** Indicates the active status of the user, typically 1 for active and 0 for inactive. */

    private byte active;

    /**
     * Returns the user's unique identifier.
     *
     * @return the userId.
     */

    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user's unique identifier.
     *
     * @param userId the userId to set.
     */

    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Returns the user's name.
     *
     * @return the Name.
     */

    public String getName() {
        return Name;
    }

    /**
     * Sets the user's name.
     *
     * @param name the Name to set.
     */

    public void setName(String name) {
        Name = name;
    }

    /**
     * Returns the user's first name.
     *
     * @return the firstName.
     */

    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user's first name.
     *
     * @param firstName the firstName to set.
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the user's description.
     *
     * @return the description.
     */

    public String getDescription() {
        return description;
    }

    /**
     * Sets the user's description.
     *
     * @param description the description to set.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the image URL or path associated with the user.
     *
     * @return the image.
     */

    public String getImage() {
        return image;
    }

    /**
     * Sets the image URL or path associated with the user.
     *
     * @param image the image to set.
     */

    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Returns the active status of the user.
     *
     * @return the active status (typically 1 for active and 0 for inactive).
     */

    public byte getActive() {
        return active;
    }

    /**
     * Sets the active status of the user.
     *
     * @param active the active status to set (typically 1 for active and 0 for inactive).
     */

    public void setActive(byte active) {
        this.active = active;
    }
}