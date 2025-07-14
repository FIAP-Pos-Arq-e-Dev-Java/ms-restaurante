package com.fiap.ms.restaurante.application.usecase.impl;

import com.fiap.ms.restaurante.application.domain.TipoCozinhaDomain;
import com.fiap.ms.restaurante.application.infraestrutura.TipoCozinha;
import com.fiap.ms.restaurante.application.usecase.AtualizarTipoCozinhaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AtualizarTipoCozinhaUseCaseImpl implements AtualizarTipoCozinhaUseCase {

    private final TipoCozinha tipoCozinha;

    @Override
    public void atualizar(Long codigo, TipoCozinhaDomain tipoCozinhaDomain) {
        tipoCozinha.buscarPorCodigo(codigo)
                .map(existing -> {
                    existing.setDescricao(tipoCozinhaDomain.getDescricao());
                    return existing;
                })
                .ifPresentOrElse(
                        tipoCozinha::salvar,
                        () -> {
                            throw new IllegalArgumentException("Tipo de cozinha não encontrado.");
                        }
                );
    }
}
