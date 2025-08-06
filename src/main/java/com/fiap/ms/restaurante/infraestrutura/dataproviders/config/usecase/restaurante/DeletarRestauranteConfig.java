package com.fiap.ms.restaurante.infraestrutura.dataproviders.config.usecase.restaurante;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.application.usecase.restaurante.implementations.DeletarRestauranteUseCaseImpl;
import com.fiap.ms.restaurante.domain.domainService.RestauranteDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarRestauranteConfig {

    @Bean
    public DeletarRestauranteUseCaseImpl deletarRestauranteUseCase(Restaurante restaurante,
                                                                   RestauranteDomainService restauranteDomainService) {
        return new DeletarRestauranteUseCaseImpl(restaurante, restauranteDomainService);
    }
}
