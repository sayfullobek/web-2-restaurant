package it.ul.restaranserverbackend2.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class JwtTokenProvider {

    @Value("${app.jwtSecretKey}")
    private String key;

    @Value("${app.jwtExpireInMilSec}")
    private Long expireDate;

    public String generateToken(UUID userId) {
        Date expire = new Date(new Date().getTime() + expireDate);
        return Jwts.builder()
                .setSubject(userId.toString())
                .setIssuedAt(new Date())
                .setExpiration(expire)
                .signWith(SignatureAlgorithm.ES512, key)
                .compact();
    }
}
