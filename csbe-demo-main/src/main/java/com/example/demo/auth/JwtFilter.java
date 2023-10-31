package com.example.demo.auth;

import com.example.demo.User.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Filter that intercepts HTTP requests to validate and process JWT tokens.
 * If a valid JWT token is found in the "Authorization" header, the user's authentication information is
 * set in the Spring Security context, enabling further request processing with the user's roles and permissions.
 */

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    /**
     * Determines whether the filter should not process the given request.
     *
     * @param request the HTTP request.
     * @return true if the request URI starts with "/auth", otherwise false.
     */

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getRequestURI().startsWith("/auth");
    }

    /*
     * Validates and processes the JWT token present in the "Authorization" header of the HTTP request.
     * If the token is valid, sets the user's authentication information in the Spring Security context.
     *
     * @param request the HTTP request.
     * @param response the HTTP response.
     * @param filterChain the filter chain.
     * @throws ServletException if a servlet-related error occurs.
     * @throws IOException if an I/O-related error occurs.
     */

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String authorization = request.getHeader("Authorization");

        if (authorization != null && !authorization.isEmpty()) {
            // Hier können Sie auf die Methoden von "authorization" zugreifen, da Sie sicher sind, dass es nicht null ist.
            String token = authorization.substring(7);

            // Restlicher vorhandener Code, um den Token zu überprüfen und die Authentifizierung durchzuführen...
            Authentication authentication = jwtService.verify(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } else {
            // Hier können Sie einen Fehler loggen oder eine andere Aktion ausführen, wenn "authorization" null oder leer ist.
            System.out.println("Fehler: Das Authorization-Token fehlt oder ist ungültig.");
            // Optional: Sie können hier auch die Anfrage ablehnen und eine geeignete Fehlermeldung an den Client zurückgeben.
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authorization-Token fehlt oder ist ungültig.");
            return;
        }

        chain.doFilter(request, response);
    }
}