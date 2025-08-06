package com.fiap.ms.restaurante.entrypoints.controllers.presenter;

import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import com.fiap.ms.restaurante.entrypoints.controllers.mappers.RestauranteDtoMapper;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteDto;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteRequestDto;

import java.util.List;

public class RestaurantePresenter {

    public static RestauranteDomain toRestauranteDomain(RestauranteRequestDto restauranteRequestDto) {
        return RestauranteDtoMapper.INSTANCE.toRestauranteDomain(restauranteRequestDto);
    }

    public static List<RestauranteDto> toListRestauranteDto(List<RestauranteDomain> domains) {
        return RestauranteDtoMapper.INSTANCE.toListRestauranteDto(domains);
    }
}
