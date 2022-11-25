package com.bosonit.ej15.security.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.*;
import java.util.stream.Collectors;

public class TokenUtils {
    private final static String ACCESS_TOKEN_SECRET="4qhq8LrEBfYcaRHxhdb9zURb2rf8e7Ud";
    private final static Long  ACCESS_TOKEN_VALIDITY_SECONDS=2_592_000L;

    private final static String AUTH =" authorities";
    private static String AUTHORITIES="";


    public static String createToken(String username, Authentication authentication){
        long expirationTime= ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate= new Date(System.currentTimeMillis()+ expirationTime);

        AUTHORITIES = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expirationDate)
                .claim(AUTH
                        ,AUTHORITIES)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }
    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {



        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String username = claims.getSubject();

            final Collection<SimpleGrantedAuthority> authorities =
                    Arrays.stream(claims.get(AUTH).toString().split(","))
                            .map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toList());

            return new UsernamePasswordAuthenticationToken(username, null, authorities);
        } catch (JwtException e) {
            return null;
        }
    }

}
