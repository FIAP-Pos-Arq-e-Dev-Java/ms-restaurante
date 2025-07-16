package com.fiap.ms.restaurante.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TipoCozinhaJaExisteException extends ResponseStatusException {

    public TipoCozinhaJaExisteException() {
        super(HttpStatus.CONFLICT, "Código ou Descrição do Tipo cozinha já cadastrado.");
    }
}
