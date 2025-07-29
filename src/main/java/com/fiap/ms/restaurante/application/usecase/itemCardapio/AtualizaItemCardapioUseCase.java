package com.fiap.ms.restaurante.application.usecase.itemCardapio;

import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;

public interface AtualizaItemCardapioUseCase {

    void atualizar(Long id, ItemCardapioDomain itemCardapioDomain);
}
