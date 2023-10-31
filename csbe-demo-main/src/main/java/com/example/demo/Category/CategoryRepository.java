package com.example.demo.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for accessing {@link Category} entities from the database.
 * <p>
 * This interface provides CRUD operations for the Category entity using Spring Data JPA.
 * </p>
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /**
     * Saves a given category to the database.
     *
     * @param category the category to save.
     * @return the saved category.
     */

    Category save(Category category);

    /**
     * Retrieves all categories from the database.
     *
     * @return a list of all categories.
     */

    List<Category> findAll();

    /**
     * Retrieves a category by its id from the database.
     *
     * @param id the id of the category to retrieve.
     * @return the category if found, otherwise an empty Optional.
     */

    Optional<Category> findById(Long id);

    /**
     * Deletes a category by its id from the database.
     *
     * @param id the id of the category to delete.
     */

    void deleteById(Long id);

    /**
     * Retrieves all categories by their name from the database.
     *
     * @param name the name of the category to retrieve.
     * @return the category if found.
     */

    Category findAllByName(String name);
}