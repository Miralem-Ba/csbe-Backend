package com.example.demo.auth;


import com.example.demo.User.User;
import com.example.demo.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * Service class responsible for authentication and authorization logic.
 * Provides methods for user registration, JWT token generation, and user role promotion.
 */

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * Registers a new user with the provided registration details.
     *
     * @param registrationDto DTO containing the user's registration details.
     */

    public void register(RegistrationDto registrationDto) {
        User user = new User();
        user.setName(registrationDto.getFirstName());
        user.setLastname(registrationDto.getLastName());
        user.setUsername(registrationDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(registrationDto.getPassword()));
        userRepository.save(user);
    }

    /**
     * Generates and returns a JWT token for a user with valid login credentials.
     *
     * @param loginDto DTO containing the user's login credentials.
     * @return a JWT token string.
     * @throws ResponseStatusException if the user is not found or if the password is incorrect.
     */

    public String getJwt(LoginDto loginDto) {
        User user = userRepository.findByUsername(loginDto.getUserName())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (!bCryptPasswordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        return jwtService.createJwt(user.getUsername());
    }

    /**
     * Promotes a user to an admin role.
     *
     * @param username the username of the user to be promoted.
     * @throws ResponseStatusException if the user is not found.
     */

    public void promoteToAdmin(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        user.setAdmin(true);
        userRepository.save(user);
    }
}
