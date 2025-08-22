package com.nest.renting.common.utils;

import com.nest.renting.common.exception.RentingException;
import com.nest.renting.common.result.ResultCodeEnum;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {


    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("LTGN6e2EBmPnNBFW5UCNlWHa7PDgpSj2".getBytes());

    public static String createToken (Long userId, String username) {
        String jwt = Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                .setSubject("LOGIN_USER")
                .claim("userId", userId)
                .claim("username", username)
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();

        return jwt;
    }

    public static Claims parseToken (String token) {
        if (token == null) {
            throw new RentingException(ResultCodeEnum.ADMIN_LOGIN_AUTH);
        }

        try {
            JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(SECRET_KEY).build();
            Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
            return claimsJws.getBody();
        } catch (ExpiredJwtException e) {
            throw new RentingException(ResultCodeEnum.TOKEN_EXPIRED);
        } catch (JwtException e) {
            throw new RentingException(ResultCodeEnum.TOKEN_INVALID);
        }
    }

}
