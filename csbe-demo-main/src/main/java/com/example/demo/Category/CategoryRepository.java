package com.example.demo.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Hier wird eine Methode erstellt, um eine neue Kategorie hinzuzufügen
    Category save(Category category);

    // Hier wird eine Methode erstellt, um alle Kategorien abzurufen
    List<Category> findAll();

    // Hier wird eine Methode erstellt, um eine Kategorie anhand ihrer ID abzurufen
    Optional<Category> findById(Long id);

    // Hier wird eine Methode erstellt, um eine Kategorie anhand ihrer ID zu löschen
    void deleteById(Long id);
}