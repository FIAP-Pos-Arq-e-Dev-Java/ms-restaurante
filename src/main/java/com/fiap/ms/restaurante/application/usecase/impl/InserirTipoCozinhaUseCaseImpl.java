package com.fiap.ms.restaurante.application.usecase.impl;

import com.fiap.ms.restaurante.application.domain.TipoCozinhaDomain;
import com.fiap.ms.restaurante.application.infraestrutura.TipoCozinha;
import com.fiap.ms.restaurante.application.usecase.InserirTipoCozinhaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InserirTipoCozinhaUseCaseImpl implements InserirTipoCozinhaUseCase {

    private final TipoCozinha tipoCozinha;

    @Override
    public void inserir(TipoCozinhaDomain tipoCozinhaDomain) {
        //REGRA VALIDAR CAMPOS TRIM "      M      "
        //REGRA VALIDAR ID EXISTENTE
        //REGRA VALIDAR DESCRICAO EXISTENTE
        tipoCozinha.salvar(tipoCozinhaDomain);
    }
}
