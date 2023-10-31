package com.example.demo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller class that handles HTTP requests related to categories.
 * <p>
 * This controller manages CRUD operations for categories using the {@link CategoryService}.
 * It provides endpoints to get all categories, retrieve a category by its ID, create,
 * update, and delete a category.
 * </p>
 */

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Qualifier("categoryService.CategoryServiceImpl")
    @Autowired
    private CategoryService categoryService;

    /**
     * Retrieves a list of all categories.
     *
     * @return a list of all categories.
     */

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    /**
     * Retrieves a category by its ID.
     *
     * @param id the ID of the category to retrieve.
     * @return the category if found, otherwise a 404 Not Found response.
     */

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Creates a new category.
     *
     * @param category the category to create.
     * @return the created category.
     */

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(createdCategory);
    }

    /**
     * Updates an existing category by its ID.
     *
     * @param id the ID of the category to update.
     * @param category the category data to update.
     * @return the updated category if found, otherwise a 404 Not Found response.
     */

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(id, category);
        if (updatedCategory != null) {
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a category by its ID.
     *
     * @param id the ID of the category to delete.
     * @return a 204 No Content response.
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
