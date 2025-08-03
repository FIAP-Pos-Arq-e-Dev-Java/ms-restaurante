package com.fiap.ms.restaurante.infraestrutura.dataproviders.config.security;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JwtAuthenticationFilterTest {

    @Mock
    private JwtUtil jwtUtil;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain filterChain;

    @Mock
    private PrintWriter printWriter;

    @InjectMocks
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @BeforeEach
    void setUp() {
        SecurityContextHolder.clearContext();
    }

    @Test
    void testDoFilterInternal_WithValidToken_ShouldSetAuthentication() throws ServletException, IOException {
        // Arrange
        String token = "valid-token";
        String authHeader = "Bearer " + token;
        Long userId = 123L;

        when(request.getHeader("Authorization")).thenReturn(authHeader);
        when(jwtUtil.isTokenValid(token)).thenReturn(true);
        when(jwtUtil.extractUserId(token)).thenReturn(userId);

        // Act
        jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);

        // Assert
        verify(filterChain).doFilter(request, response);
        assertNotNull(SecurityContextHolder.getContext().getAuthentication());
        assertEquals(userId, SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    @Test
    void testDoFilterInternal_WithInvalidToken_ShouldThrowJwtException() throws ServletException, IOException {
        // Arrange
        String token = "invalid-token";
        String authHeader = "Bearer " + token;

        when(request.getHeader("Authorization")).thenReturn(authHeader);
        when(jwtUtil.isTokenValid(token)).thenReturn(false);
        when(response.getWriter()).thenReturn(printWriter);

        // Act
        jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);

        // Assert
        verify(response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        verify(response).setContentType("application/json");
        verify(printWriter).write("{\"error\": \"Token JWT inválido ou expirado\"}");
        verify(filterChain, never()).doFilter(request, response);
    }

    @Test
    void testDoFilterInternal_WithNoAuthorizationHeader_ShouldContinueFilter() throws ServletException, IOException {
        // Arrange
        when(request.getHeader("Authorization")).thenReturn(null);

        // Act
        jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);

        // Assert
        verify(filterChain).doFilter(request, response);
        assertNull(SecurityContextHolder.getContext().getAuthentication());
    }

    @Test
    void testDoFilterInternal_WithInvalidAuthorizationHeader_ShouldContinueFilter() throws ServletException, IOException {
        // Arrange
        when(request.getHeader("Authorization")).thenReturn("Invalid header");

        // Act
        jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);

        // Assert
        verify(filterChain).doFilter(request, response);
        assertNull(SecurityContextHolder.getContext().getAuthentication());
    }

    @Test
    void testDoFilterInternal_WithEmptyBearerToken_ShouldHandleException() throws ServletException, IOException {
        // Arrange
        when(request.getHeader("Authorization")).thenReturn("Bearer ");
        when(response.getWriter()).thenReturn(printWriter);

        // Act
        jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);

        // Assert
        verify(response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        verify(response).setContentType("application/json");
        verify(printWriter).write("{\"error\": \"Token JWT inválido ou expirado\"}");
        verify(filterChain, never()).doFilter(request, response);
    }

    @Test
    void testDoFilterInternal_WhenJwtUtilThrowsException_ShouldHandleException() throws ServletException, IOException {
        // Arrange
        String token = "token-that-causes-exception";
        String authHeader = "Bearer " + token;

        when(request.getHeader("Authorization")).thenReturn(authHeader);
        when(jwtUtil.isTokenValid(token)).thenThrow(new JwtException("Token parsing error"));
        when(response.getWriter()).thenReturn(printWriter);

        // Act
        jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);

        // Assert
        verify(response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        verify(response).setContentType("application/json");
        verify(printWriter).write("{\"error\": \"Token JWT inválido ou expirado\"}");
        verify(filterChain, never()).doFilter(request, response);
    }

    @Test
    void testDoFilterInternal_WhenExtractUserIdThrowsException_ShouldHandleException() throws ServletException, IOException {
        // Arrange
        String token = "valid-token";
        String authHeader = "Bearer " + token;

        when(request.getHeader("Authorization")).thenReturn(authHeader);
        when(jwtUtil.isTokenValid(token)).thenReturn(true);
        when(jwtUtil.extractUserId(token)).thenThrow(new RuntimeException("Token inválido ou expirado", new JwtException("User ID extraction error")));
        when(response.getWriter()).thenReturn(printWriter);

        // Act
        jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);

        // Assert
        verify(response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        verify(response).setContentType("application/json");
        verify(printWriter).write("{\"error\": \"Token JWT inválido ou expirado\"}");
        verify(filterChain, never()).doFilter(request, response);
    }

    @Test
    void testConstructor() {
        // Act & Assert
        JwtAuthenticationFilter filter = new JwtAuthenticationFilter(jwtUtil);
        assertNotNull(filter);
    }
}