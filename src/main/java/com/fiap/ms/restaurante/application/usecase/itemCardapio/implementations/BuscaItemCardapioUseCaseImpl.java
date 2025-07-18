package com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations;

import com.fiap.ms.restaurante.application.gateways.ItensCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.BuscaItemCardapioUseCase;
import com.fiap.ms.restaurante.domain.model.ItensCardapioDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BuscaItemCardapioUseCaseImpl implements BuscaItemCardapioUseCase {

    private final ItensCardapio itensCardapio;

    @Override
    public List<ItensCardapioDomain> busca(String nome, Boolean disponivelSomenteNoRestaurante) {
        return itensCardapio.buscarTodos(nome, disponivelSomenteNoRestaurante);
    }
}
