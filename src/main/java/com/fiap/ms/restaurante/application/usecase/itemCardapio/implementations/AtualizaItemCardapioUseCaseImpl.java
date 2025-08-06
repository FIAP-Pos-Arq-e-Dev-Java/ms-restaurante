package com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations;

import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.AtualizaItemCardapioUseCase;
import com.fiap.ms.restaurante.domain.domainService.ItemCardapioDomainService;
import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;

import static com.fiap.ms.restaurante.domain.rules.ValidarDescricaoObrigatoriaRule.validarDescricaoObrigatoria;

public class AtualizaItemCardapioUseCaseImpl implements AtualizaItemCardapioUseCase {

    private final ItemCardapio itemCardapio;
    private final ItemCardapioDomainService itemCardapioDomainService;

    public AtualizaItemCardapioUseCaseImpl(ItemCardapio itemCardapio,
                                           ItemCardapioDomainService itemCardapioDomainService) {
        this.itemCardapio = itemCardapio;
        this.itemCardapioDomainService = itemCardapioDomainService;
    }

    @Override
    public void atualizar(Long id, ItemCardapioDomain itemCardapioDomain) {
        validarDescricaoObrigatoria(itemCardapioDomain.getDescricao());

        ItemCardapioDomain domain = itemCardapioDomainService.buscarItemCardapioPorId(id);

        domain.setNome(itemCardapioDomain.getNome());
        domain.setDescricao(itemCardapioDomain.getDescricao());
        domain.setPreco(itemCardapioDomain.getPreco());
        domain.setDisponibilidadeConsumoLocal(itemCardapioDomain.getDisponibilidadeConsumoLocal());
        itemCardapio.salvar(domain);
    }
}
