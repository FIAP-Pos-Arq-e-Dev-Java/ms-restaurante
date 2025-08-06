package com.fiap.ms.restaurante.infraestrutura.dataproviders.config.usecase.itemCardapio;

import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations.BuscarItemCardapioUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarItemCardapioConfig {

    @Bean
    public BuscarItemCardapioUseCaseImpl buscarItemCardapioUseCase(ItemCardapio itemCardapio) {
        return new BuscarItemCardapioUseCaseImpl(itemCardapio);
    }
}
