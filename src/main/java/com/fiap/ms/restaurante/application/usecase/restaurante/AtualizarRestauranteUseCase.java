package com.fiap.ms.restaurante.application.usecase.restaurante;

import com.fiap.ms.restaurante.domain.model.RestauranteDomain;

import java.util.UUID;

public interface AtualizarRestauranteUseCase {

    void atualizar(UUID id, RestauranteDomain restauranteDomain);
}
