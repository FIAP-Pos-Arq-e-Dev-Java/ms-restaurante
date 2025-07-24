package com.fiap.ms.restaurante.application.usecase.restaurante.implementations;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.application.usecase.restaurante.DeletarRestauranteUseCase;
import com.fiap.ms.restaurante.domain.domainService.RestauranteDomainService;
import com.fiap.ms.restaurante.domain.exception.ObjetoNaoExisteException;
import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DeletarRestauranteUseCaseImpl implements DeletarRestauranteUseCase {

    private final Restaurante restaurante;
    private final RestauranteDomainService  restauranteDomainService;

    @Override
    public void deletar(UUID id) {
        RestauranteDomain domain = restauranteDomainService.buscaRestaurantePorId(id);
        restaurante.deletar(domain);
    }
}
