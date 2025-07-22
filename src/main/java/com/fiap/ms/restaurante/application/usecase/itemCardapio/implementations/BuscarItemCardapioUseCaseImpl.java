package com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations;

import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.BuscaItemCardapioUseCase;
import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BuscarItemCardapioUseCaseImpl implements BuscaItemCardapioUseCase {

    private final ItemCardapio itemCardapio;

    @Override
    public List<ItemCardapioDomain> buscar(String nome, Boolean disponibilidadeConsumoLocal) {
        return itemCardapio.buscarTodos(nome, disponibilidadeConsumoLocal);
    }
}
