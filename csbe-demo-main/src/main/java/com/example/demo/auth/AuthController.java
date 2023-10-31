package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class that handles authentication and authorization requests.
 * Provides endpoints for user registration, login, and promotion to admin roles.
 */

@RestController
public class AuthController {

    @Autowired
    private com.example.demo.auth.AuthService authService;

    /**
     * Registers a new user with the provided details.
     *
     * @param registrationDto DTO containing the user's registration details.
     * @return a ResponseEntity indicating the success of the registration process.
     */

    @PostMapping("/auth/registration")
    public ResponseEntity<String> register(@RequestBody RegistrationDto registrationDto) {
        authService.register(registrationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered");
    }

    /**
     * Logs in a user with the provided credentials.
     *
     * @param loginDto DTO containing the user's login credentials.
     * @return a ResponseEntity containing the JWT token if authentication is successful.
     */

    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authService.getJwt(loginDto));
    }

    /**
     * Promotes a user to an admin role.
     * This should be used with caution and proper authorization checks.
     *
     * @param username the username of the user to be promoted.
     * @return a ResponseEntity indicating the success of the promotion process.
     */

    @PostMapping("/auth/promote")
    public ResponseEntity<String> promoteToAdmin(@RequestBody String username) {
        // You should verify that the current user is admin before allowing the promotion.
        authService.promoteToAdmin(username);
        return ResponseEntity.status(HttpStatus.OK).body("User promoted to admin");
    }
}