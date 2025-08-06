package com.fiap.ms.restaurante.infraestrutura.dataproviders.config.usecase.restaurante;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.application.usecase.restaurante.implementations.BuscarRestauranteUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarRestauranteConfig {

    @Bean
    public BuscarRestauranteUseCaseImpl buscarRestauranteUseCase(Restaurante restaurante) {
        return new BuscarRestauranteUseCaseImpl(restaurante);
    }
}
