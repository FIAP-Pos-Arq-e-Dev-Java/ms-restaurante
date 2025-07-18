package com.fiap.ms.restaurante.application.usecase.itemCardapio;


import com.fiap.ms.restaurante.domain.model.ItensCardapioDomain;

import java.util.List;

public interface BuscaItemCardapioUseCase {

    List<ItensCardapioDomain> busca(String nome, Boolean disponivelSomenteNoRestaurante);
}
