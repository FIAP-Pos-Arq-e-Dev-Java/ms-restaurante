package com.fiap.ms.restaurante.entrypoints.controllers.handler;

import com.fiap.ms.restaurante.domain.exception.CampoObrigatorioException;
import com.fiap.ms.restaurante.domain.exception.ObjetoJaExisteException;
import com.fiap.ms.restaurante.domain.exception.ObjetoNaoExisteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler handler;
    private WebRequest webRequest;

    @BeforeEach
    void setUp() {
        handler = new GlobalExceptionHandler();
        webRequest = mock(WebRequest.class);
        when(webRequest.getDescription(false)).thenReturn("uri=/api/teste");
    }

    @Test
    void deveTratarCampoObrigatorioException() {
        CampoObrigatorioException ex = new CampoObrigatorioException("descricao");

        ResponseEntity<Object> response = handler.handleCampoObrigatorioException(ex, webRequest);

        assertEquals(400, response.getStatusCodeValue());
        assertTrue(response.getBody() instanceof Map);

        Map<String, Object> body = (Map<String, Object>) response.getBody();
        assertEquals("BAD_REQUEST", body.get("error"));
        assertEquals("/api/teste", body.get("path"));
        assertNotNull(body.get("timestamp"));
    }

    @Test
    void deveTratarObjetoJaExisteException() {
        ObjetoJaExisteException ex = new ObjetoJaExisteException("Tipo já existe");

        ResponseEntity<Object> response = handler.handleTipoCozinhaJaExisteException(ex, webRequest);

        assertEquals(409, response.getStatusCodeValue());
        assertTrue(response.getBody() instanceof Map);

        Map<String, Object> body = (Map<String, Object>) response.getBody();
        assertEquals("CONFLICT", body.get("error"));
        assertEquals("Tipo já existe", body.get("message"));
        assertEquals("/api/teste", body.get("path"));
        assertNotNull(body.get("timestamp"));
    }

    @Test
    void deveTratarObjetoNaoExisteException() {
        ObjetoNaoExisteException ex = new ObjetoNaoExisteException("Tipo não encontrado");

        ResponseEntity<Object> response = handler.handleTipoCozinhaNaoExisteException(ex, webRequest);

        assertEquals(404, response.getStatusCodeValue());
        assertTrue(response.getBody() instanceof Map);

        Map<String, Object> body = (Map<String, Object>) response.getBody();
        assertEquals("NOT_FOUND", body.get("error"));
        assertEquals("Tipo não encontrado", body.get("message"));
        assertEquals("/api/teste", body.get("path"));
        assertNotNull(body.get("timestamp"));
    }

    @Test
    void deveTratarMissingServletRequestParameterException_comMensagemCorreta() {
        MissingServletRequestParameterException ex = new MissingServletRequestParameterException("id", "String");

        ResponseEntity<?> response = handler.handleMissingParams(ex);

        assertEquals(400, response.getStatusCodeValue());
        assertTrue(response.getBody() instanceof Map);

        @SuppressWarnings("unchecked")
        Map<String, Object> body = (Map<String, Object>) response.getBody();
        assertEquals("O parâmetro 'id' é obrigatório.", body.get("error"));
    }

    @Test
    void deveTratarOutroParametroFaltando_comMensagemDiferente() {
        MissingServletRequestParameterException ex = new MissingServletRequestParameterException("nome", "String");

        ResponseEntity<?> response = handler.handleMissingParams(ex);

        assertEquals(400, response.getStatusCodeValue());
        assertTrue(response.getBody() instanceof Map);

        @SuppressWarnings("unchecked")
        Map<String, Object> body = (Map<String, Object>) response.getBody();
        assertEquals("O parâmetro 'nome' é obrigatório.", body.get("error"));
    }
}
