package com.sanemizci.starter.jwt;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.util.function.Function;

import java.util.Date;
import java.security.Key;

@Service
public class JWTService {
     public static final String SECRET_KEY = "JefMTi_-b2rz2ndhdQXp1b22xomCu5BNO6FogxLqTJg";

    public String generateToken(UserDetails userDetails) {
       


        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*2))
                .signWith(getKey(),SignatureAlgorithm.HS256)
                .compact();
    }


    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
        .setSigningKey(getKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
    }
    public <T> T exportToken(String token, Function<Claims, T> claimsResolver) {
       Claims claims= getClaims(token);
       return claimsResolver.apply(claims);
       
    }
    public String getUsernameFromToken(String token) {
       return exportToken(token, Claims::getSubject);
    }
    public Boolean isTokenValid(String token) {
        Date expirationDate=exportToken(token, Claims::getExpiration);
        return new Date().before(expirationDate);
    }

    public Key getKey() {
        byte[] bytes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(bytes);
    }
}
