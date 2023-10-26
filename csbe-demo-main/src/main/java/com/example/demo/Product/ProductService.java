package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);

    @Service
    public class ProductServiceImpl implements ProductService {

        @Autowired
        private ProductRepository productRepository;

        @Override
        public Product createProduct(Product product) {
            return productRepository.save(product);
        }

        @Override
        public Product getProductById(Long id) {
            Optional<Product> productOptional = productRepository.findById(id);
            if (productOptional.isPresent()) {
                return productOptional.get();
            } else {
                throw new ResourceNotFoundException("Product with ID " + id + " not found.");
            }
        }

        @Override
        public List<Product> getAllProducts() {
            return productRepository.findAll();
        }

        @Override
        public Product updateProduct(Long id, Product product) {
            Product existingProduct = getProductById(id);
            // Weitere Eigenschaften aktualisieren, falls erforderlich
            return productRepository.save(existingProduct);
        }

        @Override
        public void deleteProduct(Long id) {
            productRepository.deleteById(id);
        }
    }
}
