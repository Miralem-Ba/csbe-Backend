package com.example.demo.Category;

/**
 * Data Transfer Object (DTO) for the {@link Category} entity.
 * <p>
 * This class is responsible for transferring category data between different application layers
 * without exposing the details of the domain objects/entities. It provides utility methods to
 * convert between the entity and DTO representations.
 * </p>
 */

public class CategoryDTO {

    private Long id;
    private String name;

    /**
     * Default constructor.
     */

    public CategoryDTO() {}

    /**
     * Constructs a new CategoryDTO with the given id and name.
     *
     * @param id   the category id.
     * @param name the category name.
     */

    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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

    /**
     * Converts a {@link Category} entity to its DTO representation.
     *
     * @param category the category entity to convert.
     * @return the DTO representation of the given category.
     */

    public static CategoryDTO fromEntity(Category category) {
        return new CategoryDTO(category.getId(), category.getName());
    }

    /**
     * Converts this DTO to its {@link Category} entity representation.
     *
     * @return the category entity representation of this DTO.
     */

    public Category toEntity() {
        Category category = new Category();
        category.setId(this.id);
        category.setName(this.name);
        return category;
    }
}