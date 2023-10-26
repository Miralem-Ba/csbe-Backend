package com.example.demo.Category;


import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    public interface CategoryService {
        Category createCategory(Category category);

        Category getCategoryById(Long id);

        List<Category> getAllCategories();

        Category updateCategory(Long id, Category category);

        void deleteCategory(Long id);

        @Service// Dieses Annotation gibt an, dass dies ein Spring-Service ist
        public class CategoryServiceImpl implements CategoryService {

            private final CategoryRepository categoryRepository; // Hier müssen Sie Ihre Repository-Klasse einfügen

            // Konstruktor zur Injektion des Repository
            public CategoryServiceImpl(CategoryRepository categoryRepository) {
                this.categoryRepository = categoryRepository;
            }

            @Override
            public Category createCategory(Category category) {
                // Implementieren Sie die Logik, um eine Kategorie zu erstellen und im Repository zu speichern
                // Normalerweise erfolgt dies über categoryRepository.save(category)
                // Hier ist ein Beispiel, wie es aussehen könnte:
                return categoryRepository.save(category);
            }

            @Override
            public Category getCategoryById(Long id) {
                // Implementieren Sie die Logik, um eine Kategorie anhand ihrer ID abzurufen
                // Normalerweise erfolgt dies über categoryRepository.findById(id)
                // Hier ist ein Beispiel, wie es aussehen könnte:
                Optional<Category> categoryOptional = categoryRepository.findById(id);
                if (categoryOptional.isPresent()) {
                    return categoryOptional.get();
                } else {
                    throw new ResourceNotFoundException("Kategorie nicht gefunden"); // Passen Sie die Exception an Ihre Bedürfnisse an
                }
            }

            @Override
            public List<Category> getAllCategories() {
                // Implementieren Sie die Logik, um alle Kategorien abzurufen
                // Normalerweise erfolgt dies über categoryRepository.findAll()
                // Hier ist ein Beispiel, wie es aussehen könnte:
                return categoryRepository.findAll();
            }

            @Override
            public Category updateCategory(Long id, Category category) {
                // Implementieren Sie die Logik, um eine Kategorie zu aktualisieren
                // Normalerweise erfolgt dies über categoryRepository.save(category)
                // Hier ist ein Beispiel, wie es aussehen könnte:
                Category existingCategory = categoryRepository.findById(id).orElse(null);
                if (existingCategory != null) {
                    // Aktualisieren Sie die Eigenschaften der vorhandenen Kategorie mit den neuen Werten aus 'category'
                    existingCategory.setName(category.getName());
                    // Weitere Eigenschaften aktualisieren...
                    return categoryRepository.save(existingCategory);
                } else {
                    throw new ResourceNotFoundException("Kategorie nicht gefunden");
                }
            }

            @Override
            public void deleteCategory(Long id) {
                // Implementieren Sie die Logik, um eine Kategorie anhand ihrer ID zu löschen
                // Normalerweise erfolgt dies über categoryRepository.deleteById(id)
                // Hier ist ein Beispiel, wie es aussehen könnte:
                if (categoryRepository.existsById(id)) {
                    categoryRepository.deleteById(id);
                } else {
                    throw new ResourceNotFoundException("Kategorie nicht gefunden");
                }
            }
        }
    }

