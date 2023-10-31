// Dies ist die UserServiceTest.java Datei:

package com.example.demo.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void getUserById_withValidId_returnsUser() {
        // Vorbereiten
        Long userId = 1L;
        User mockUser = new User();
        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));

        // Ausführen
        User result = userService.getUserById(userId);

        // Überprüfen
        assertNotNull(result);
        assertEquals(mockUser, result);
    }

    @Test
    public void getUserById_withInvalidId_throwsException() {
        // Vorbereiten
        Long userId = 1L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Überprüfen
        assertThrows(ResourceNotFoundException.class, () -> userService.getUserById(userId));
    }
}
