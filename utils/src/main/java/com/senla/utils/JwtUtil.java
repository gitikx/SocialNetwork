package com.senla.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;

public class JwtUtil {
    private static final Key key = MacProvider.generateKey();

    public static String getToken(String nameValue) {
        return Jwts.builder().setSubject(nameValue).signWith(SignatureAlgorithm.HS512, key).compact();
    }

    public static String verifyToken(String token){
        try {
            return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
        }
        catch (Exception ex){
            return null;
        }
    }

}
