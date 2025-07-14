package com.fiap.ms.restaurante.application.usecase.impl;

import com.fiap.ms.restaurante.application.domain.TipoCozinhaDomain;
import com.fiap.ms.restaurante.application.infraestrutura.TipoCozinha;
import com.fiap.ms.restaurante.application.usecase.BuscarTipoCozinhaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BuscarTipoCozinhaUseCaseImpl implements BuscarTipoCozinhaUseCase {

    private final TipoCozinha tipoCozinha;

    @Override
    public List<TipoCozinhaDomain> buscar(Long codigo, String descricao) {
        return tipoCozinha.buscar(codigo, descricao);
    }
}
