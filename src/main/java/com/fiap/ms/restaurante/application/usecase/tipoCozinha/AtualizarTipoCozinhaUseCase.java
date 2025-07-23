package com.fiap.ms.restaurante.application.usecase.tipoCozinha;

import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;

import java.util.UUID;

public interface AtualizarTipoCozinhaUseCase {

    void atualizar(UUID codigo, TipoCozinhaDomain tipoCozinhaDomain);
}
