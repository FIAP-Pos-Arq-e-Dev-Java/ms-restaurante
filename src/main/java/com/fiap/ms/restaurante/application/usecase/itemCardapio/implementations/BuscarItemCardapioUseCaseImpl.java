package com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations;

import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.BuscaItemCardapioUseCase;
import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;

import java.util.List;

public class BuscarItemCardapioUseCaseImpl implements BuscaItemCardapioUseCase {

    private final ItemCardapio itemCardapio;

    public BuscarItemCardapioUseCaseImpl(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
    }

    @Override
    public List<ItemCardapioDomain> buscar(String nome, Boolean disponibilidadeConsumoLocal) {
        return itemCardapio.buscarTodos(nome, disponibilidadeConsumoLocal);
    }
}
