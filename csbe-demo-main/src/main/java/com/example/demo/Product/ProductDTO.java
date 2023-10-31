package com.example.demo.Product;

import com.example.demo.Category.CategoryDTO;

/**
 * Data Transfer Object (DTO) for {@link Product}. This class is used to transfer
 * product data between different application layers without exposing the entire
 * product entity.
 */

public class ProductDTO {

    private Long id;
    private String name;
    private CategoryDTO category;

    /**
     * Default constructor.
     */

    public ProductDTO() {}

    /**
     * Parametrized constructor.
     *
     * @param id       the product ID
     * @param name     the name of the product
     * @param category the category DTO associated with the product
     */

    public ProductDTO(Long id, String name, CategoryDTO category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    // Getter and Setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    /**
     * Converts a product entity to its DTO representation.
     *
     * @param product the product entity
     * @return the DTO representation of the product
     */

    public static ProductDTO fromEntity(Product product) {
        CategoryDTO categoryDTO = (product.getCategory() != null) ? CategoryDTO.fromEntity(product.getCategory()) : null;
        return new ProductDTO(product.getId(), product.getName(), categoryDTO);
    }

    /**
     * Converts this DTO to its product entity representation.
     *
     * @return the product entity
     */

    public Product toEntity() {
        Product product = new Product();
        product.setId(this.id);
        product.setName(this.name);
        product.setCategory((this.category != null) ? this.category.toEntity() : null);
        return product;
    }
}