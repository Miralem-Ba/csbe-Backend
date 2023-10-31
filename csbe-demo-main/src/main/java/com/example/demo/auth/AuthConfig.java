package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Configuration class for authentication and authorization.
 * Defines rules for API endpoint access based on roles and authorities.
 */
@Configuration
public class AuthConfig {

    @Autowired
    private JwtFilter jwtFilter;

    /**
     * Configures and returns the security filter chain.
     * This method defines rules for API endpoint access.
     *
     * @param httpSecurity the HttpSecurity instance to be configured.
     * @return a SecurityFilterChain configured with authorization and other security settings.
     * @throws Exception if an error occurs during the configuration.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)  // Add the JWT filter
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    // Define access permissions for various API paths
                    authorizationManagerRequestMatcherRegistry
                            .requestMatchers(new AntPathRequestMatcher("/auth/*")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("api/user/**")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/persons")).hasAuthority("admin")
                            .requestMatchers(new AntPathRequestMatcher("/persons/*", HttpMethod.GET.name())).hasAnyAuthority("admin", "user")
                            .requestMatchers(new AntPathRequestMatcher("/persons/*", HttpMethod.DELETE.name())).hasAuthority("admin")
                            .anyRequest().authenticated();  // All other requests require authentication
                })
                .httpBasic(AbstractHttpConfigurer::disable)  // Disable basic authentication
                .csrf(AbstractHttpConfigurer::disable)  // Disable CSRF protection
                .build();
    }
}