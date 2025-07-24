package com.fiap.ms.restaurante.application.usecase.tipoCozinha;

import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;

public interface AtualizarTipoCozinhaUseCase {

    void atualizar(Long codigo, TipoCozinhaDomain tipoCozinhaDomain);
}
