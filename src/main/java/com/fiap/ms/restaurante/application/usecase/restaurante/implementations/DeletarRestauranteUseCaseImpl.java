package com.fiap.ms.restaurante.application.usecase.restaurante.implementations;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.application.usecase.restaurante.DeletarRestauranteUseCase;
import com.fiap.ms.restaurante.domain.domainService.RestauranteDomainService;
import com.fiap.ms.restaurante.domain.model.RestauranteDomain;

public class DeletarRestauranteUseCaseImpl implements DeletarRestauranteUseCase {

    private final Restaurante restaurante;
    private final RestauranteDomainService  restauranteDomainService;

    public DeletarRestauranteUseCaseImpl(Restaurante restaurante,
                                         RestauranteDomainService  restauranteDomainService) {
        this.restaurante = restaurante;
        this.restauranteDomainService = restauranteDomainService;
    }

    @Override
    public void deletar(Long id) {
        RestauranteDomain domain = restauranteDomainService.buscaRestaurantePorId(id);
        restaurante.deletar(domain);
    }
}
