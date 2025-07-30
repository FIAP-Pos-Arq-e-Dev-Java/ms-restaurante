package com.fiap.ms.restaurante.entrypoints.controllers.mappers;

import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteDto;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface RestauranteDtoMapper {

    RestauranteDtoMapper INSTANCE = Mappers.getMapper(RestauranteDtoMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuarioId", ignore = true)
    RestauranteDomain toRestauranteDomain(RestauranteRequestDto restauranteRequestDto);

    RestauranteDto toRestauranteDto(RestauranteDomain restauranteDomain);
}
