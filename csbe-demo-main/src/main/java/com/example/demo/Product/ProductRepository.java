package com.example.demo.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for CRUD operations on {@link Product} entities.
        * It extends Spring Data JPA's JpaRepository to provide common database operations without custom implementations.
        */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Saves a given product entity to the database.
     * If the product already exists, it updates the product; otherwise, it inserts a new product.
     *
     * @param product the product entity to be saved
     * @return the saved product entity
     */

    Product save(Product product);

    /**
     * Retrieves all products from the database.
     *
     * @return a list of all products
     */

    List<Product> findAll();

    /**
     * Retrieves a product by its ID from the database.
     *
     * @param id the ID of the product to be retrieved
     * @return an Optional of the product if found, or an empty Optional if not found
     */

    Optional<Product> findById(Long id);

    /**
     * Deletes a product by its ID from the database.
     *
     * @param id the ID of the product to be deleted
     */

    void deleteById(Long id);
}
