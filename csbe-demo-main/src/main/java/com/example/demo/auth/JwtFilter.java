package com.example.demo.auth;

import com.example.demo.User.User;
import com.example.demo.User.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

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

    /**
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
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        String jwt = authorization.substring("Bearer ".length());
        String userName = jwtService.getUserName(jwt);
        Optional<User>  user= userRepository.findByUsername(userName);

        if (user.isPresent()) {
            List<GrantedAuthority> authorities = List.of(() -> user.get().isAdmin() ? "admin" : "user");
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userName, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);
        }
    }
}