package com.example.demo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing user-related database operations.
 * <p>
 * This repository provides an abstraction layer over the underlying database operations
 * for User entities. It extends the JpaRepository interface which provides methods
 * to perform CRUD operations. Custom methods are also defined to meet specific requirements.
 * </p>
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Persists the given user entity to the database.
     *
     * @param user the user entity to be saved.
     * @return the persisted user entity.
     */

    User save(User user);

    /**
     * Fetches a list of users with the given username.
     *
             * @param title the username to search for.
            * @return a list of users having the specified username.
            */
    List<User> findAllByUsername(String title);

    /**
     * Retrieves a user entity based on its unique identifier.
     *
     * @param id the unique identifier of the user.
     * @return an Optional containing the user entity if found, empty otherwise.
     */

    Optional<User> findById(Long id);

    /**
     * Removes a user entity from the database based on its unique identifier.
     *
     * @param id the unique identifier of the user to be deleted.
     */

    void deleteById(Long id);

    /**
     * Retrieves a user entity based on its username.
     *
     * @param username the username of the user.
     * @return an Optional containing the user entity if found, empty otherwise.
     */

    Optional<User> findByUsername(String username);
}