package com.example.demo.User;

public class UserAuthDTO extends UserDto {

    /** The authentication or authorization token associated with the user. */

    private String token;

    /**
     * Default constructor.
     */

    public UserAuthDTO() {
    }

    /**
     * Constructs a new UserAuthDTO with the provided user details and authentication token.
     *
     * @param userId      the user's ID
     * @param name        the user's name
     * @param firstName   the user's first name
     * @param description the user's description
     * @param image       the image associated with the user
     * @param active      a flag indicating if the user is active
     * @param token       the authentication token associated with the user
     */

    public UserAuthDTO(int userId, String name, String firstName, String description, String image, byte active, String token) {
        super.setUserId(userId);
        super.setName(name);
        super.setFirstName(firstName);
        super.setDescription(description);
        super.setImage(image);
        super.setActive(active);
        this.token = token;
    }

    /**
     * Returns the authentication token associated with the user.
     *
     * @return the authentication token
     */

    public String getToken() {
        return token;
    }

    /**
     * Sets the authentication token for the user.
     *
     * @param token the authentication token to set
     */

    public void setToken(String token) {
        this.token = token;
    }
}