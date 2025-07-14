package com.fiap.ms.restaurante.application.usecase;

import com.fiap.ms.restaurante.application.domain.TipoCozinhaDomain;

import java.util.List;

public interface BuscarTipoCozinhaUseCase {

    List<TipoCozinhaDomain> buscar(Long codigo, String descricao);
}
