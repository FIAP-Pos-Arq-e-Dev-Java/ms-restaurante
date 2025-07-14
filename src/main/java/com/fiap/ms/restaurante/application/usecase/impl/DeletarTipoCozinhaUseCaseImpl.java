package com.fiap.ms.restaurante.application.usecase.impl;

import com.fiap.ms.restaurante.application.infraestrutura.TipoCozinha;
import com.fiap.ms.restaurante.application.usecase.DeletarTipoCozinhaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeletarTipoCozinhaUseCaseImpl implements DeletarTipoCozinhaUseCase {

    private final TipoCozinha tipoCozinha;

    @Override
    public void deletar(Long codigo) {
        tipoCozinha.buscarPorCodigo(codigo)
                .ifPresentOrElse(
                        tipoCozinha::deletar,
                        () -> {
                            throw new IllegalArgumentException("Tipo de cozinha não encontrado.");
                        }
                );
    }
}
