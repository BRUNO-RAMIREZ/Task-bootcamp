package com.dhasset.auth_service.security;

import com.dhasset.auth_service.model.domain.AuthUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Bruno Ramirez
 **/
@Component
public class JwtProvider {

    private Key secret;

    @PostConstruct
    protected void init() {
        byte[] apiKeySecretBytes = new byte[64];
        new SecureRandom().nextBytes(apiKeySecretBytes);
        secret = Keys.hmacShaKeyFor(apiKeySecretBytes);
    }

    public String createToken(AuthUser authUser) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",authUser.getId());

        Date now = new Date();
        Date exp = new Date(now.getTime() + 3600000);

        return Jwts.builder()
                .claims(claims)
                .subject(authUser.getUserName())
                .issuedAt(now)
                .expiration(exp)
                .signWith(Keys.hmacShaKeyFor(secret.getEncoded()))
                .compact();
    }

    public boolean validate(String token){
        try{
            Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getEncoded())).build().parseSignedClaims(token);
            return true;
        } catch (Exception exception){
            return false;
        }
    }

    public String getUserNameFromToken(String token){
        try{
            return Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getEncoded()))
                    .build()
                    .parseSignedClaims(token).getPayload().getSubject();
        }catch (Exception exception){
            return "Bad token";
        }
    }
}
