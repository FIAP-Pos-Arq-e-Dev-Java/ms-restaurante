package com.fiap.ms.restaurante.infraestrutura.dataproviders.config.usecase.restaurante;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.application.usecase.restaurante.implementations.AtualizarRestauranteUseCaseImpl;
import com.fiap.ms.restaurante.domain.domainService.RestauranteDomainService;
import com.fiap.ms.restaurante.domain.domainService.TipoCozinhaDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarRestauranteConfig {

    @Bean
    public AtualizarRestauranteUseCaseImpl atualizarRestauranteUseCase(Restaurante restaurante,
                                                                       RestauranteDomainService restauranteDomainService,
                                                                       TipoCozinhaDomainService tipoCozinhaDomainService) {
        return new AtualizarRestauranteUseCaseImpl(restaurante, restauranteDomainService, tipoCozinhaDomainService);
    }
}
