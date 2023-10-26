package com.example.demo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Hier wird eine Methode erstellt, um einen neuen Benutzer hinzuzufügen
    User save(User user);

    // Hier wird eine Methode erstellt, um alle Benutzer mit einem bestimmten Benutzernamen abzurufen
    List<User> findAllByUsername(String title);

    // Hier wird eine Methode erstellt, um einen Benutzer anhand seiner ID abzurufen
    Optional<User> findById(Long id);

    // Hier wird eine Methode erstellt, um einen Benutzer anhand seiner ID zu löschen
    void deleteById(Long id);

    Optional<User> findByUsername(String username);

    Optional<User> findByUserName(String userName);
}