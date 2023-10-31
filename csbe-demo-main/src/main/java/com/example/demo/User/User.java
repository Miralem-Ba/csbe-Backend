package com.example.demo.User;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Represents a user within the system.
 * Each user has attributes like name, username, and password, among others,
 * and can have multiple associated products.
 */

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String name;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String lastname;

    @Column( columnDefinition = "varchar(255)")
    private String username;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String password;

    @Column(columnDefinition = "text")
    private String description;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String image;

    @Column
    private byte active;

    @Column
    private boolean isAdmin;

    @Column
    private int productId;

    /**
     * Gets the unique identifier for this user.
     *
     * @return the identifier for this user.
     * // Getter & Setter
     */

    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this user.
     *
     * @param id the new identifier for this user.
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the user's first name.
     *
     * @return the first name of this user.
     */

    public String getName() {
        return name;
    }

    /**
     * Sets the user's first name.
     *
     * @param name the new first name for this user.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the last name of the user.
     *
     * @param lastName not used.
     * @return the current last name of the user.
     */

    public String getLastname(Object lastName) {
        return lastname;
    }

    /**
     * Setzt den Nachnamen des Benutzers.
     *
     * @param lastname der neue Nachname des Benutzers.
     */

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Returns the username of the user.
     *
     * @return the current username of the user.
     */

    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the new username of the user.
     */

    public void setUsername(String username) {
        username = username;
    }

    /**
     * Returns the password of the user.
     *
     * @return the current password of the user.
     */

    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the new password of the user.
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gibt die Beschreibung des Benutzers zurück.
     *
     * @return die aktuelle Beschreibung des Benutzers.
     */

    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the user.
     *
     * @param description the new description of the user.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the image of the user.
     *
     * @return the current image of the user.
     */

    public String getImage() {
        return image;
    }

    /**
     * Sets the image of the user.
     *
     * @param image the new image of the user.
     */

    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Returns the activation status of the user.
     *
     * @return the current activation status of the user.
     */

    public byte getActive() {
        return active;
    }

    /**
     * Sets the activation status of the user.
     *
     * @param active the new activation status of the user.
     */

    public void setActive(byte active) {
        this.active = active;
    }

    /**
     * Checks if the user is an administrator.
     *
     * @return 'true' if the user is an administrator, otherwise 'false'.
     */

    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Sets the administrator status of the user.
     *
     * @param admin 'true' if the user should be an administrator, otherwise 'false'.
     */

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    /**
     * Returns the product ID of the user.
     *
     * @return the current product ID of the user.
     */

    public int getProductId() {
        return productId;
    }

    /**
     * Setzt die Produkt-ID des Benutzers.
     *
     * @param productId die neue Produkt-ID des Benutzers.
     */

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", active=" + active +
                ", isAdmin=" + isAdmin +
                ", productId=" + productId +
                '}';
    }


    @Repository
    public interface UserRepository extends JpaRepository<User, Integer> {
        List<User> findByIsAdminTrue();
    }
}