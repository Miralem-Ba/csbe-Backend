package com.example.demo.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Service class responsible for JWT (JSON Web Token) operations.
 * Provides methods for creating JWTs and retrieving usernames from them.
 */

@Service
public class JwtService {

    /**
     * Secret key for signing the JWT.
     */

    private final String secret = "MySecret";

    /**
     * Creates a JWT for a given username.
     * The token has an issuer, issue date, expiration date, and the user's name as the subject.
     * The token is signed with the HS256 algorithm using a secret key.
     *
     * @param userName the username for which the JWT is created.
     * @return the JWT string.
     */

    public String createJwt(String userName) {
        return Jwts
                .builder()
                .setIssuer("CsBE")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() * 60 * 60 * 24 * 20)) // TODO: 10/28/23 fix time
                .setSubject(userName)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    /**
     * Retrieves the username from a given JWT.
     * The token is parsed and verified using the secret signing key.
     *
     * @param jwt the JWT string from which the username is retrieved.
     * @return the username.
     */

    public String getUserName(String jwt) {
        return Jwts
                .parser()
                .setSigningKey(secret)
                .parseClaimsJws(jwt)
                .getBody()
                .getSubject();
    }

    public Authentication verify(String token) {
        return null;
    }
}