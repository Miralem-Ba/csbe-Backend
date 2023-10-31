package com.example.demo.Category;

import com.example.demo.Product.Product;
import jakarta.persistence.*;
import java.util.List;

/**
 * Represents a product category.
 * <p>
 * This class models a category which can have multiple products associated with it.
 * Each category has a unique ID and a name. The relationship between Category and Product
 * is a one-to-many relationship, i.e., one category can have multiple products, but each product
 * can belong to only one category.
 * </p>
 * */

@Entity
public class Category {

    /** The unique ID of the category. */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** The name of the category. */

    @Column(columnDefinition = "varchar(255)")
    private String name;

    /** List of products that belong to this category. */

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    // Default constructor, getters, and setters ...

    /**
     * Returns the unique ID of the category.
     *
     * @return the ID of the category.
     */

    public Long getId() {
        return id;
    }

    /**
     * Sets the ID for the category.
     *
     * @param id the ID to set.
     */

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the category.
     *
     * @return the name of the category.
     */

    public String getName() {
        return name;
    }

    /**
     * Sets the name for the category.
     *
     * @param name the name to set.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the list of products that belong to this category.
     *
     * @return the products of this category.
     */

    public List<Product> getProducts() {
        return products;
    }

    /**
     * Sets the list of products for this category.
     *
     * @param products the products to set.
     */

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}