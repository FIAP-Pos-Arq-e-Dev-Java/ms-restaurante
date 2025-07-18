package com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations;

import com.fiap.ms.restaurante.application.gateways.ItensCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.InserirItemCardapioUseCase;
import com.fiap.ms.restaurante.domain.model.ItensCardapioDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InserirItemCardapioUseCaseImpl implements InserirItemCardapioUseCase {

    private final ItensCardapio itensCardapioDataSource;

    @Override
    public void inserir(ItensCardapioDomain domain) {
        itensCardapioDataSource.salvar(domain);
    }
}
