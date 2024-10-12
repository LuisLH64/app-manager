package com.app_manager.security;

import java.util.Date;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class JwtUtil {
    
    private static final String SECRET_KEY = "52f5ea76-8ace-4d14-bf2a-da32fa94b26e";
    private static final Algorithm ALGORITHM = Algorithm.HMAC512(SECRET_KEY);

    public String generateToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Token expira em 10 horas
                .sign(ALGORITHM);
    }

    public String validateTokenAndGetUsername(String token) {
        
        try {
            JWTVerifier verifier = JWT.require(ALGORITHM).build();
            DecodedJWT decodedJWT = verifier.verify(token);

            return decodedJWT.getSubject();  
        } 
        catch (JWTVerificationException e) {
            throw new RuntimeException("Token JWT inválido ou expirado");
        }
    }

    public boolean isTokenExpired(String token) {
        
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getExpiresAt().before(new Date());
    }
    
}
