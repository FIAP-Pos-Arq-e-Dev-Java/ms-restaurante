package com.fiap.ms.restaurante.domain.rules;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class ExtrairUserIdDoTokenRuleTest {

    private MockedStatic<SecurityContextHolder> securityContextHolderMock;

    @AfterEach
    void tearDown() {
        if (securityContextHolderMock != null) {
            securityContextHolderMock.close();
        }
    }

    @Test
    void deveRetornarUserIdQuandoPrincipalForNumeroValido() {
        String expectedId = "12345";
        Authentication authentication = Mockito.mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn(expectedId);

        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);

        securityContextHolderMock = Mockito.mockStatic(SecurityContextHolder.class);
        securityContextHolderMock.when(SecurityContextHolder::getContext).thenReturn(securityContext);

        Long result = ExtrairUserIdDoTokenRule.obterUserId();

        assertEquals(12345L, result);
    }

    @Test
    void deveLancarIllegalStateExceptionQuandoAuthenticationForNulo() {
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(null);

        securityContextHolderMock = Mockito.mockStatic(SecurityContextHolder.class);
        securityContextHolderMock.when(SecurityContextHolder::getContext).thenReturn(securityContext);

        IllegalStateException ex = assertThrows(IllegalStateException.class, ExtrairUserIdDoTokenRule::obterUserId);
        assertEquals("Usuário não autenticado ou token inválido.", ex.getMessage());
    }

    @Test
    void deveLancarIllegalStateExceptionQuandoPrincipalForNulo() {
        Authentication authentication = Mockito.mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn(null);

        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);

        securityContextHolderMock = Mockito.mockStatic(SecurityContextHolder.class);
        securityContextHolderMock.when(SecurityContextHolder::getContext).thenReturn(securityContext);

        IllegalStateException ex = assertThrows(IllegalStateException.class, ExtrairUserIdDoTokenRule::obterUserId);
        assertEquals("Usuário não autenticado ou token inválido.", ex.getMessage());
    }

    @Test
    void deveLancarIllegalStateExceptionQuandoPrincipalNaoForNumeroValido() {
        String invalidId = "abc123";
        Authentication authentication = Mockito.mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn(invalidId);

        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);

        securityContextHolderMock = Mockito.mockStatic(SecurityContextHolder.class);
        securityContextHolderMock.when(SecurityContextHolder::getContext).thenReturn(securityContext);

        IllegalStateException ex = assertThrows(IllegalStateException.class, ExtrairUserIdDoTokenRule::obterUserId);
        assertEquals("ID do usuário no token é inválido.", ex.getMessage());
    }

    @Test
    void testeCoberturaController() {
        ExtrairUserIdDoTokenRule  extrairUserIdDoTokenRule = new ExtrairUserIdDoTokenRule ();

        assertNotNull(extrairUserIdDoTokenRule);
    }
}