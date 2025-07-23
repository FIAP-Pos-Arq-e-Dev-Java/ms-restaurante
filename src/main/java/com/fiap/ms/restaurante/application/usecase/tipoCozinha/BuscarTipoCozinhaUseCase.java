package com.fiap.ms.restaurante.application.usecase.tipoCozinha;

import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;

import java.util.List;
import java.util.UUID;

public interface BuscarTipoCozinhaUseCase {

    List<TipoCozinhaDomain> buscar(UUID codigo, String descricao);
}
