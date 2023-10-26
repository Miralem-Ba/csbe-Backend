package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public class UserService {
    User createUser(User user) {
        return null;
    }

    User getUserById(Long id) {
        return null;
    }

    List<User> getAllUsers() {
        return null;
    }

    User updateUser(Long id, User user) {

        return user;
    }

    void deleteUser(Long id) {
    }

    @Service
    public static class UserServiceImpl extends UserService {

        @Autowired
        private UserRepository userRepository;

        @Override
        public User getUserById(Long id) {
            return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Users with the id " + id + " could not be found!"));
        }

        @Override
        public List<User> getAllUsers() {
            return userRepository.findAll();
        }

        @Override
        public User createUser(User user) {
            return userRepository.save(user);
        }

        @Override
        public User updateUser(Long id, User user) {
            User existingUser = getUserById(id);

            // Überprüfen, ob die übergebene Benutzer-ID mit der vorhandenen Benutzer-ID übereinstimmt
            if (!user.getId().equals(existingUser.getId())) {
                throw new IllegalArgumentException("User ID mismatch.");
            }

            // Weitere Eigenschaften aktualisieren, falls erforderlich
            existingUser.equals(user.getId());
            existingUser.getId();
            // Weitere Eigenschaften aktualisieren, falls erforderlich

            return userRepository.save(existingUser);
        }

        @Override
        public void deleteUser(Long id) {

        }
    }
}
