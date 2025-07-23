package com.fiap.ms.restaurante.application.usecase.itemCardapio;

import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;

import java.util.UUID;

public interface AtualizaItemCardapioUseCase {

    void atualiza(UUID id, ItemCardapioDomain itemCardapioDomain);
}
