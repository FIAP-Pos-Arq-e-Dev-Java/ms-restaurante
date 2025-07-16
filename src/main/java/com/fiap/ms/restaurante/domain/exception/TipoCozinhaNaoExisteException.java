package com.fiap.ms.restaurante.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TipoCozinhaNaoExisteException extends ResponseStatusException {

    public TipoCozinhaNaoExisteException() {
        super(HttpStatus.NOT_FOUND, "Tipo cozinha não está cadastrada.");
    }
}
