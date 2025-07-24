package com.fiap.ms.restaurante.application.usecase.itemCardapio;

import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;

import java.util.UUID;

public interface AtualizaItemCardapioUseCase {

    void atualizar(UUID id, ItemCardapioDomain itemCardapioDomain);
}
