package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service class responsible for managing user-related operations.
 * <p>
 * This service provides methods to perform CRUD operations on User entities
 * and interacts with the UserRepository to interact with the database.
 * </p>
 */

@Service
public class UserService {

    /** The UserRepository that this service interacts with. */

    @Autowired
    private UserRepository userRepository;

    /**
     * Retrieves a User based on its unique identifier.
     *
     * @param id the unique identifier of the User.
     * @return the retrieved User entity.
     * @throws ResourceNotFoundException if the User with the given ID is not found.
     */

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Users with the id " + id + " could not be found!"));
    }

    /**
     * Retrieves a list of all Users.
     *
     * @return a list of all User entities.
     */

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Persists a new User entity to the database.
     *
     * @param user the User entity to be saved.
     * @return the persisted User entity.
     */

    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Updates an existing User entity with new information.
     *
     * @param id   the unique identifier of the User to be updated.
     * @param user the User entity with updated information.
     * @return the updated User entity.
     */

    public User updateUser(Long id, User user) {
        User existingUser = getUserById(id);

        // TODO: Update the required properties of the existing user here.

        existingUser.equals(user.getId());
        existingUser.getId();
        // Weitere Eigenschaften aktualisieren, falls erforderlich

        return userRepository.save(existingUser);
    }

    /**
     * Deletes a User entity from the database.
     *
     * @param id the unique identifier of the User to be deleted.
     * @throws ResourceNotFoundException if the User with the given ID is not found.
     */
    public void deleteUser(Long id) {
        // First we check if the user exists, otherwise we throw an exception.
        User existingUser = getUserById(id);

        // If the user exists, we delete it.
        userRepository.delete(existingUser);
    }
}