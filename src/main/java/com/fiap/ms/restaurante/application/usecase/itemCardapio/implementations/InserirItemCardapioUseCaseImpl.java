package com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations;

import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.InserirItemCardapioUseCase;
import com.fiap.ms.restaurante.domain.domainService.ItemCardapioDomainService;
import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;

import static com.fiap.ms.restaurante.domain.rules.ValidarDescricaoObrigatoriaRule.validarDescricaoObrigatoria;

public class InserirItemCardapioUseCaseImpl implements InserirItemCardapioUseCase {

    private final ItemCardapio itemCardapioDataSource;
    private final ItemCardapioDomainService itemCardapioDomainService;

    public InserirItemCardapioUseCaseImpl(ItemCardapio itemCardapioDataSource,
                                          ItemCardapioDomainService itemCardapioDomainService) {
        this.itemCardapioDataSource = itemCardapioDataSource;
        this.itemCardapioDomainService = itemCardapioDomainService;
    }

    @Override
    public void inserir(ItemCardapioDomain domain) {
        validarDescricaoObrigatoria(domain.getDescricao());

        itemCardapioDomainService.checarExistenciaItem(domain.getDescricao(), domain.getRestauranteId(), domain.getNome());

        itemCardapioDataSource.salvar(domain);
    }
}
