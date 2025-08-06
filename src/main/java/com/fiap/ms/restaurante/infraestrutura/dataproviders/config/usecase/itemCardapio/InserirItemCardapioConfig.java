package com.fiap.ms.restaurante.infraestrutura.dataproviders.config.usecase.itemCardapio;

import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations.InserirItemCardapioUseCaseImpl;
import com.fiap.ms.restaurante.domain.domainService.ItemCardapioDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InserirItemCardapioConfig {

    @Bean
    public InserirItemCardapioUseCaseImpl inserirItemCardapioUseCase(ItemCardapio itemCardapioDataSource,
                                                                     ItemCardapioDomainService itemCardapioDomainService) {
        return new InserirItemCardapioUseCaseImpl(itemCardapioDataSource, itemCardapioDomainService);
    }
}
