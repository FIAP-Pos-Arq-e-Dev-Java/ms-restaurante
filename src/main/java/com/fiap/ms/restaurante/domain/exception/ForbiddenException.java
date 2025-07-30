package com.fiap.ms.restaurante.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ForbiddenException extends ResponseStatusException {

    public ForbiddenException(String mensagem) {
        super(HttpStatus.FORBIDDEN, mensagem);
    }
}
