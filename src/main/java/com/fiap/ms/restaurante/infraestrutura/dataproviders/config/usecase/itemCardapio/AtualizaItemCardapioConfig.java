package com.fiap.ms.restaurante.infraestrutura.dataproviders.config.usecase.itemCardapio;

import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations.AtualizaItemCardapioUseCaseImpl;
import com.fiap.ms.restaurante.domain.domainService.ItemCardapioDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizaItemCardapioConfig {

    @Bean
    public AtualizaItemCardapioUseCaseImpl atualizaItemCardapioUseCase(ItemCardapio itemCardapio,
                                                                       ItemCardapioDomainService itemCardapioDomainService) {
        return new AtualizaItemCardapioUseCaseImpl(itemCardapio, itemCardapioDomainService);
    }
}
