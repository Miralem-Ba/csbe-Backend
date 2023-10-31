package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * A Rest Controller that provides endpoints to manage users.
 * <p>
 * This controller handles CRUD operations related to users,
 * including retrieving all users, retrieving a user by ID, creating a user, updating a user,
 * and deleting a user.
 * </p>
 */

@RestController
@RequestMapping("/api/users")
public class UserController {

    /** The service class that contains business logic related to users. */

    @Autowired
    private UserService userService;

    /**
     * Retrieves a list of all users.
     *
     * @return a list of all users.
     */

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Retrieves a specific user by their ID.
     *
     * @param id the ID of the user to retrieve.
     * @return the user if found, otherwise a 404 Not Found response.
     */

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Creates a new user.
     *
     * @param user the user data to create.
     * @return the created user.
     */

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    /**
     * Updates a specific user.
     *
     * @param id   the ID of the user to update.
     * @param user the updated user data.
     * @return the updated user if found and updated, otherwise a 404 Not Found response.
     */

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a specific user by their ID.
     *
     * @param id the ID of the user to delete.
     * @return a 204 No Content response indicating the user has been deleted.
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}