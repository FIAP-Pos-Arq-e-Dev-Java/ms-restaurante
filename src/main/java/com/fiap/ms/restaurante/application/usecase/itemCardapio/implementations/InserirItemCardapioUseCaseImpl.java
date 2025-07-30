package com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations;

import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.InserirItemCardapioUseCase;
import com.fiap.ms.restaurante.domain.domainService.ItemCardapioDomainService;
import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.fiap.ms.restaurante.domain.rules.ValidarDescricaoObrigatoriaRule.validarDescricaoObrigatoria;

@RequiredArgsConstructor
@Service
public class InserirItemCardapioUseCaseImpl implements InserirItemCardapioUseCase {

    private final ItemCardapio itemCardapioDataSource;
    private final ItemCardapioDomainService itemCardapioDomainService;

    @Override
    public void inserir(ItemCardapioDomain domain) {
        validarDescricaoObrigatoria(domain.getDescricao());

        itemCardapioDomainService.checarExistenciaDescricao(domain.getDescricao());

        itemCardapioDataSource.salvar(domain);
    }
}
