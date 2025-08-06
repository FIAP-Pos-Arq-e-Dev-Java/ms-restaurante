package com.fiap.ms.restaurante.application.usecase.tipoCozinha.implementations;

import com.fiap.ms.restaurante.application.gateways.TipoCozinha;
import com.fiap.ms.restaurante.application.usecase.tipoCozinha.BuscarTipoCozinhaUseCase;
import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;

import java.util.List;

public class BuscarTipoCozinhaUseCaseImpl implements BuscarTipoCozinhaUseCase {

    private final TipoCozinha tipoCozinha;

    public BuscarTipoCozinhaUseCaseImpl(TipoCozinha tipoCozinha) {
        this.tipoCozinha = tipoCozinha;
    }

    @Override
    public List<TipoCozinhaDomain> buscar(Long codigo, String descricao) {
        return tipoCozinha.buscar(codigo, descricao);
    }
}
