package com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations;


import com.fiap.ms.restaurante.application.gateways.ItensCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.AtualizaItemCardapioUseCase;
import com.fiap.ms.restaurante.domain.model.ItensCardapioDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AtualizaItemCardapioUseCaseImpl implements AtualizaItemCardapioUseCase {

    private final ItensCardapio itensCardapio;

    @Override
    public void atualiza(Long id, ItensCardapioDomain itensCardapioDomain) {
        itensCardapio.findById(id).
                map(exists -> {
                    exists.setNome(itensCardapioDomain.getNome());
                    exists.setDescricao(itensCardapioDomain.getDescricao());
                    exists.setPreco(itensCardapioDomain.getPreco());
                    exists.setDisponibilidade(itensCardapioDomain.getDisponibilidade());
                    return exists;
                })
                .ifPresentOrElse(itensCardapio::salvar, () -> {
                    throw new IllegalArgumentException("Item do cardapio não encontrado!");
                });
    }
}
