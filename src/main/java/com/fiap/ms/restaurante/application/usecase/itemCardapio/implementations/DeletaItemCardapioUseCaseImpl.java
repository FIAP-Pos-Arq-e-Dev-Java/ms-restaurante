package com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations;

import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.DeletaItemCardapioUseCase;
import com.fiap.ms.restaurante.domain.domainService.ItemCardapioDomainService;
import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DeletaItemCardapioUseCaseImpl implements DeletaItemCardapioUseCase {

    private final ItemCardapio itemCardapio;
    private final ItemCardapioDomainService itemCardapioDomainService;

    @Override
    public void deletar(UUID id) {
        ItemCardapioDomain domain = itemCardapioDomainService.buscarItemCardapioPorId(id);
        itemCardapio.deletar(domain);
    }
}
