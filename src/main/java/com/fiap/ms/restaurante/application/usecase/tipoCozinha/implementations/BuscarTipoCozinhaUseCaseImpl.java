package com.fiap.ms.restaurante.application.usecase.tipoCozinha.implementations;

import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import com.fiap.ms.restaurante.application.gateways.TipoCozinha;
import com.fiap.ms.restaurante.application.usecase.tipoCozinha.BuscarTipoCozinhaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BuscarTipoCozinhaUseCaseImpl implements BuscarTipoCozinhaUseCase {

    private final TipoCozinha tipoCozinha;

    @Override
    public List<TipoCozinhaDomain> buscar(UUID codigo, String descricao) {
        return tipoCozinha.buscar(codigo, descricao);
    }
}
