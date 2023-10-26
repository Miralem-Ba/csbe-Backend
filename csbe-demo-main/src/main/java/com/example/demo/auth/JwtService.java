package com.example.demo.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpirationMs;

    public static String getUsername(String jwt) {
        String secret = null;
        return Jwts
                .parser()
                .setSigningKey((String) null)
                .parseClaimsJws(jwt)
                .getBody()
                .getSubject();
    }

    public String generateJwtToken(String username) {
        return Jwts
                .builder()
                .setIssuer("CsBe")
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date((System.currentTimeMillis()) * 601 * 60 * 24 * 20))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (Exception e) {
            // Log the error (e) in a real application
        }
        return false;
    }

    public String createJwt(Object userName) {
        return null;
    }

    public String getUserName(String jwt) {
        return jwt;
    }
}
