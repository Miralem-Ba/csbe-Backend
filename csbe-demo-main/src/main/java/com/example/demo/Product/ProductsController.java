package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * RESTful controller for managing {@link Product} entities.
 * It provides endpoints for CRUD operations on products.
 */

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    /**
     * RESTful controller for managing {@link Product} entities.
     * It provides endpoints for CRUD operations on products.
     */

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Retrieves a specific product by its ID.
     *
     * @param id the ID of the product to be retrieved
     * @return a ResponseEntity containing the product if found or a 404 Not Found status if not
     */

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Creates a new product in the system.
     *
     * @param product the product entity to be created
     * @return a ResponseEntity containing the created product
     */

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    /**
     * Updates a specific product by its ID.
     *
     * @param id the ID of the product to be updated
     * @param product the product entity containing the updated details
     * @return a ResponseEntity containing the updated product if found or a 404 Not Found status if not
     */

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a specific product by its ID.
     *
     * @param id the ID of the product to be deleted
     * @return a ResponseEntity with a 204 No Content status
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
