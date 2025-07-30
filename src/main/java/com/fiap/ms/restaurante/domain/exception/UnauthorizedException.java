package com.fiap.ms.restaurante.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UnauthorizedException extends ResponseStatusException {

    public UnauthorizedException(String mensagem) {
        super(HttpStatus.UNAUTHORIZED, mensagem);
    }
}
