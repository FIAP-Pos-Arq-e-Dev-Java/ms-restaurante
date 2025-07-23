package com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations;

import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.AtualizaItemCardapioUseCase;
import com.fiap.ms.restaurante.domain.domainService.ItemCardapioDomainService;
import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.fiap.ms.restaurante.domain.rules.ValidarDescricaoObrigatoriaRule.validar;

@RequiredArgsConstructor
@Service
public class AtualizaItemCardapioUseCaseImpl implements AtualizaItemCardapioUseCase {

    private final ItemCardapio itemCardapio;
    private final ItemCardapioDomainService itemCardapioDomainService;

    @Override
    public void atualiza(UUID id, ItemCardapioDomain itemCardapioDomain) {
        validar(itemCardapioDomain.getDescricao());

        ItemCardapioDomain domain = itemCardapioDomainService.buscarItemCardapioPorId(id);

        domain.setNome(itemCardapioDomain.getNome());
        domain.setDescricao(itemCardapioDomain.getDescricao());
        domain.setPreco(itemCardapioDomain.getPreco());
        domain.setDisponibilidadeConsumoLocal(itemCardapioDomain.getDisponibilidadeConsumoLocal());
        itemCardapio.salvar(domain);
    }
}
