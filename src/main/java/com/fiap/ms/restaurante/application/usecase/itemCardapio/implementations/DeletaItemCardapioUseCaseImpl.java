package com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations;

import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.DeletaItemCardapioUseCase;
import com.fiap.ms.restaurante.domain.domainService.ItemCardapioDomainService;
import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;

public class DeletaItemCardapioUseCaseImpl implements DeletaItemCardapioUseCase {

    private final ItemCardapio itemCardapio;
    private final ItemCardapioDomainService itemCardapioDomainService;

    public DeletaItemCardapioUseCaseImpl (ItemCardapio itemCardapio,
                                          ItemCardapioDomainService itemCardapioDomainService) {
        this.itemCardapio = itemCardapio;
        this.itemCardapioDomainService = itemCardapioDomainService;
    }

    @Override
    public void deletar(Long id) {
        ItemCardapioDomain domain = itemCardapioDomainService.buscarItemCardapioPorId(id);
        itemCardapio.deletar(domain);
    }
}
