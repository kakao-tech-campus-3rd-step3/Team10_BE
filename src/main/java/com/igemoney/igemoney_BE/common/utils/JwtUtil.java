package com.igemoney.igemoney_BE.common.utils;


import com.igemoney.igemoney_BE.user.entity.User;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;


@Component
public class JwtUtil {

    private final SecretKey secretKey;
    private final long expirationMs;

    public JwtUtil(@Value("${jwt.secret}") String secretKey, @Value("${jwt.expiration}") long expirationMs) {
        this.secretKey = Keys.hmacShaKeyFor(secretKey.getBytes());
        this.expirationMs = expirationMs;
    }

    public String generateToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationMs);

        return Jwts.builder()
            .subject(user.getUserId().toString())
            .claim("nickname", user.getNickname())
            .claim("consecutiveAttendance", user.getConsecutiveAttendance().toString())
            .claim("todayCount", user.getTodayCount())
            .issuedAt(now)
            .expiration(expiryDate)
            .signWith(secretKey, Jwts.SIG.HS256)
            .compact();
    }

    public String extractJwtTokenFromHeader(HttpServletRequest request) {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7);
        }

        return null;
    }

    public Boolean validateJwtToken(String token) {
        try {
            // jwt를 파싱하는 코드지만 가장 큰 목적은 파싱 도중 잘못된 토큰이면 예외를 뱉어내는 데에 있다
            Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parse(token);
            return true;

        } catch (SecurityException e) {
            throw new IllegalArgumentException("decryption를 실패했습니다.", e);
        } catch (MalformedJwtException e) {
            throw new IllegalArgumentException("신뢰할 수 없는 토큰입니다.", e);
        } catch (ExpiredJwtException e) {
            throw new IllegalArgumentException("토큰이 만료됐습니다.", e);
        } catch (Exception e) {
            throw new IllegalArgumentException("유효하지 않은 토큰입니다.", e);
        }

    }

    public String getSubject(String token) {
        try{
            return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
        } catch (Exception e) {
            throw new IllegalArgumentException("유효하지 않은 토큰입니다.", e);
        }
    }


}
