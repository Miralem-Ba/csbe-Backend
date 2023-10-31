package com.example.demo.Product;

import com.example.demo.Category.Category;
import jakarta.persistence.*;

/**
 * Represents a product entity in the database.
 */

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "varchar(255)")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category; // Use your own Category entity

    @Column
    private float price;

    @Column(columnDefinition = "text")
    private String description;

    @Column(name = "floor")
    private int Floor;

    @Column(columnDefinition = "varchar(2048)")
    private String imagePath;

    /**
     * @return the ID of the product.
     */

    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the product.
     *
     * @param id the product ID to set.
     */

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name of the product.
     */

    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name the product name to set.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the category associated with the product.
     */

    public Category getCategory() {
        return category;
    }

    /**
     * Associates the product with a category.
     *
     * @param category the category to associate with the product.
     */

    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the price of the product.
     */

    public float getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price the price to set for the product.
     */

    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the description of the product.
     */

    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the product.
     *
     * @param description the product description to set.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the floor number or value associated with the product.
     */

    public int getFloor() {
        return Floor;
    }

    /**
     * Sets the floor number or value for the product.
     *
     * @param floor the floor value to set.
     */

    public void setFloor(int floor) {
        Floor = floor;
    }

    /**
     * @return the image path or URL associated with the product.
     */

    public String getImagePath() {
        return imagePath;
    }

    /**
     * Sets the image path or URL for the product.
     *
     * @param imagePath the image path to set.
     */

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * Placeholder method. Its purpose is unclear and may require further implementation.
     *
     * @param s a string value.
     */

    public void Floor(String s) {
    }
}