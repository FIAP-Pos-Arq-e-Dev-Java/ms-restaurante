package com.fiap.ms.restaurante.application.usecase.tipoCozinha;

import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;

import java.util.List;

public interface BuscarTipoCozinhaUseCase {

    List<TipoCozinhaDomain> buscar(Long codigo, String descricao);
}
