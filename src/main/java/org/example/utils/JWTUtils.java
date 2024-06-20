package org.example.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

public class JWTUtils {
    private static final String key = "cfcd";
    private static final int expiresTime = 1000 * 60 * 60 * 12;

    public static String genToken(Map<String, Object> claims) {
        return JWT.create().withClaim("claims", claims).withExpiresAt(new Date(System.currentTimeMillis() + expiresTime)).sign(Algorithm.HMAC256(key));
    }

    public static Map<String, Object> parseToken(String token) {
        return JWT.require(Algorithm.HMAC256(key)).build().verify(token).getClaim("claims").asMap();
    }

}
