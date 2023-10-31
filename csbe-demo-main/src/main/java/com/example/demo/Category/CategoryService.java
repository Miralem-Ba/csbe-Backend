package com.example.demo.Category;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Interface to define operations for category service.
 */

    public interface CategoryService {

        /**
     * Creates a new category.
     *
     * @param category the category to create.
     * @return the created category.
     */

        Category createCategory(Category category);

    /**
     * Retrieves a category by its ID.
     *
     * @param id the ID of the category to retrieve.
     * @return the retrieved category.
     */

        Category getCategoryById(Long id);

    /**
     * Retrieves all categories.
     *
     * @return a list of all categories.
     */

        List<Category> getAllCategories();

    /**
     * Updates an existing category by its ID.
     *
     * @param id the ID of the category to update.
     * @param category the updated category data.
     * @return the updated category.
     */

        Category updateCategory(Long id, Category category);

    /**
     * Deletes a category by its ID.
     *
     * @param id the ID of the category to delete.
     */

        void deleteCategory(Long id);

    /**
     * Service implementation of {@link CategoryService} for CRUD operations on {@link Category} entity.
     */

        @Service// Dieses Annotation gibt an, dass dies ein Spring-Service ist
        public class CategoryServiceImpl implements CategoryService {

            private final CategoryRepository categoryRepository; // Here you have to insert your repository class

        /**
         * Constructor for dependency injection.
         *
         * @param categoryRepository the repository to access the category data.
         */

            public CategoryServiceImpl(CategoryRepository categoryRepository) {
                this.categoryRepository = categoryRepository;
            }

            @Override
            public Category createCategory(Category category) {
                // Implement the logic to create a category and save it to the repository.
                // Normally this is done via categoryRepository.save(category)
                // Here is an example of how it might look:
                return categoryRepository.save(category);
            }

            @Override
            public Category getCategoryById(Long id) {
                // Implement the logic to retrieve a category by its ID.
                // Normally this is done via categoryRepository.findById(id).
                // Here is an example of how it might look:
                Optional<Category> categoryOptional = categoryRepository.findById(id);
                if (categoryOptional.isPresent()) {
                    return categoryOptional.get();
                } else {
                    throw new ResourceNotFoundException("Kategorie nicht gefunden"); // Customize the exception to your needs
                }
            }

            @Override
            public List<Category> getAllCategories() {
                // Implement the logic to retrieve all categories.
                // Normally this is done via categoryRepository.findAll()
                // Here is an example of how it might look:
                return categoryRepository.findAll();
            }

            @Override
            public Category updateCategory(Long id, Category category) {

                // Implement the logic to update a category.
                // Normally this is done via categoryRepository.save(category)
                // Here is an example of how it might look:

                Category existingCategory = categoryRepository.findById(id).orElse(null);
                if (existingCategory != null) {

                    // Update the properties of the existing category with the new values from 'category'.

                    existingCategory.setName(category.getName());

                    // Update more properties...
                    return categoryRepository.save(existingCategory);
                } else {
                    throw new ResourceNotFoundException("Kategorie nicht gefunden");
                }
            }

            @Override
            public void deleteCategory(Long id) {
                // Implement the logic to delete a category by its id.
                // Normally this is done via categoryRepository.deleteById(id)
                // Here is an example of how it might look:
                if (categoryRepository.existsById(id)) {
                    categoryRepository.deleteById(id);
                } else {
                    throw new ResourceNotFoundException("Kategorie nicht gefunden");
                }
            }
        }
    }