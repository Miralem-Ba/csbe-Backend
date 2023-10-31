package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Service layer for managing {@link Product} entities.
 * This service provides methods for CRUD operations on products and uses the {@link ProductRepository} for data access.
 */

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Creates a new product in the system.
     *
     * @param product the product entity to be created
     * @return the created product
     */

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Retrieves a specific product by its ID.
     *
     * @param id the ID of the product to be retrieved
     * @return the product if found, or null otherwise
     */

    public Product getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElse(null);
    }

    /**
     * Retrieves all products from the system.
     *
     * @return a list of all products
     */

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Updates details of a specific product by its ID.
     *
     * @param id the ID of the product to be updated
     * @param product the product entity containing the updated details
     * @return the updated product if found, or null otherwise
     */

    public Product updateProduct(Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            existingProduct.setName(product.getName());  // Example: Update product name
            // ... further properties to be updated can be added here
            return productRepository.save(existingProduct);
        } else {
            return null;
        }
    }

    /**
     * Deletes a specific product by its ID.
     *
     * @param id the ID of the product to be deleted
     */

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}