package com.fiap.ms.restaurante.infraestrutura.dataproviders.config.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {

    private JwtUtil jwtUtil;
    private static final String SECRET_KEY = "DbqQrnCVpwdEsoU7YVUxiAOG1vajrqdp33jFk5abEFHTM8A7pyJzFWfrApt42gW8";

    @BeforeEach
    void setUp() {
        jwtUtil = new JwtUtil();
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    private String createValidToken(Long userId) {
        return Jwts.builder()
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 hours
                .signWith(getSigningKey())
                .compact();
    }

    private String createExpiredToken(Long userId) {
        return Jwts.builder()
                .claim("userId", userId)
                .setIssuedAt(new Date(System.currentTimeMillis() - 86400000)) // 24 hours ago
                .setExpiration(new Date(System.currentTimeMillis() - 3600000)) // 1 hour ago
                .signWith(getSigningKey())
                .compact();
    }

    @Test
    void testIsTokenValid_WithValidToken_ShouldReturnTrue() {
        // Arrange
        String validToken = createValidToken(123L);

        // Act
        boolean result = jwtUtil.isTokenValid(validToken);

        // Assert
        assertTrue(result);
    }

    @Test
    void testIsTokenValid_WithInvalidToken_ShouldReturnFalse() {
        // Arrange
        String invalidToken = "invalid.token.here";

        // Act
        boolean result = jwtUtil.isTokenValid(invalidToken);

        // Assert
        assertFalse(result);
    }

    @Test
    void testIsTokenValid_WithExpiredToken_ShouldReturnFalse() {
        // Arrange
        String expiredToken = createExpiredToken(123L);

        // Act
        boolean result = jwtUtil.isTokenValid(expiredToken);

        // Assert
        assertFalse(result);
    }

    @Test
    void testIsTokenValid_WithNullToken_ShouldReturnFalse() {
        // Act
        boolean result = jwtUtil.isTokenValid(null);

        // Assert
        assertFalse(result);
    }

    @Test
    void testIsTokenValid_WithEmptyToken_ShouldReturnFalse() {
        // Act
        boolean result = jwtUtil.isTokenValid("");

        // Assert
        assertFalse(result);
    }

    @Test
    void testIsTokenValid_WithMalformedToken_ShouldReturnFalse() {
        // Arrange
        String malformedToken = "malformed";

        // Act
        boolean result = jwtUtil.isTokenValid(malformedToken);

        // Assert
        assertFalse(result);
    }

    @Test
    void testExtractUserId_WithValidToken_ShouldReturnUserId() {
        // Arrange
        Long expectedUserId = 123L;
        String validToken = createValidToken(expectedUserId);

        // Act
        Long result = JwtUtil.extractUserId(validToken);

        // Assert
        assertEquals(expectedUserId, result);
    }

    @Test
    void testExtractUserId_WithInvalidToken_ShouldThrowRuntimeException() {
        // Arrange
        String invalidToken = "invalid.token.here";

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            JwtUtil.extractUserId(invalidToken);
        });

        assertEquals("Token inválido ou expirado", exception.getMessage());
    }

    @Test
    void testExtractUserId_WithExpiredToken_ShouldThrowRuntimeException() {
        // Arrange
        String expiredToken = createExpiredToken(123L);

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            JwtUtil.extractUserId(expiredToken);
        });

        assertEquals("Token inválido ou expirado", exception.getMessage());
    }

    @Test
    void testExtractUserId_WithNullToken_ShouldThrowRuntimeException() {
        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            JwtUtil.extractUserId(null);
        });

        assertEquals("Token inválido ou expirado", exception.getMessage());
    }

    @Test
    void testExtractUserId_WithEmptyToken_ShouldThrowRuntimeException() {
        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            JwtUtil.extractUserId("");
        });

        assertEquals("Token inválido ou expirado", exception.getMessage());
    }

    @Test
    void testExtractUserId_WithTokenWithoutUserId_ShouldThrowRuntimeException() {
        // Arrange
        String tokenWithoutUserId = Jwts.builder()
                .claim("otherClaim", "value")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(getSigningKey())
                .compact();

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            JwtUtil.extractUserId(tokenWithoutUserId);
        });

        assertEquals("Token inválido ou expirado", exception.getMessage());
        assertTrue(exception.getCause() instanceof NullPointerException);
    }

    @Test
    void testExtractUserId_WithDifferentUserIds_ShouldReturnCorrectValues() {
        // Test with different user IDs
        Long[] userIds = {1L, 999L, 12345L, 0L};

        for (Long userId : userIds) {
            // Arrange
            String token = createValidToken(userId);

            // Act
            Long result = JwtUtil.extractUserId(token);

            // Assert
            assertEquals(userId, result, "Failed for userId: " + userId);
        }
    }
}