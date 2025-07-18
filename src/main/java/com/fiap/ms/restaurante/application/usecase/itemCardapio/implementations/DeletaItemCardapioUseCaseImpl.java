package com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations;


import com.fiap.ms.restaurante.application.gateways.ItensCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.DeletaItemCardapioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeletaItemCardapioUseCaseImpl implements DeletaItemCardapioUseCase {

    private final ItensCardapio itensCardapio;

    @Override
    public void deletar(Long id) {
        itensCardapio.findById(id)
                .ifPresentOrElse(itensCardapio::deletar, () -> {
                    throw new IllegalArgumentException("Item cardápio inexistente");
                });
    }
}
