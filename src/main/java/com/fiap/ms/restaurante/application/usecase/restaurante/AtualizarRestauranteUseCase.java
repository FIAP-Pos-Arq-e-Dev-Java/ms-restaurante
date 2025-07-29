package com.fiap.ms.restaurante.application.usecase.restaurante;

import com.fiap.ms.restaurante.domain.model.RestauranteDomain;

public interface AtualizarRestauranteUseCase {

    void atualizar(Long id, RestauranteDomain restauranteDomain);
}
