package com.fiap.ms.restaurante.application.usecase.itemCardapio;

import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;

import java.util.List;

public interface BuscaItemCardapioUseCase {

    List<ItemCardapioDomain> buscar(String nome, Boolean disponibilidadeConsumoLocal);
}
