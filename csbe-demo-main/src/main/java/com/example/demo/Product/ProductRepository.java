package com.example.demo.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Hier wird eine Methode erstellt, um ein neues Produkt hinzuzufügen
    Product save(Product product);

    // Hier wird eine Methode erstellt, um alle Produkte abzurufen
    List<Product> findAll();

    // Hier wird eine Methode erstellt, um ein Produkt anhand seiner ID abzurufen
    Optional<Product> findById(Long id);
    //Hier wird eine Methode erstellt, um ein Produkt anhand seiner ID zu löschen
    void deleteById(Long id);
}
