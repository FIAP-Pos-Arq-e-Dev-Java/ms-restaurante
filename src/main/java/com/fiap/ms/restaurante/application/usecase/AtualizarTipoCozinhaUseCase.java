package com.fiap.ms.restaurante.application.usecase;

import com.fiap.ms.restaurante.application.domain.TipoCozinhaDomain;

public interface AtualizarTipoCozinhaUseCase {

    void atualizar(Long codigo, TipoCozinhaDomain tipoCozinhaDomain);
}
