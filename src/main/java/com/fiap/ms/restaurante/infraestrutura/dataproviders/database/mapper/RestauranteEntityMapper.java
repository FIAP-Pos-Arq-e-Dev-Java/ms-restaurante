package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.mapper;

import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import com.fiap.ms.restaurante.entrypoints.controllers.mappers.ItemCardapioDtoMapper;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.RestauranteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface RestauranteEntityMapper {

    RestauranteEntityMapper INSTANCE = Mappers.getMapper(RestauranteEntityMapper.class);

    @Mapping(source = "tipoCozinhaId", target = "tipoCozinha.codigo")
    @Mapping(target = "itemCardapio", ignore = true)
    RestauranteEntity toRestauranteEntity(RestauranteDomain restauranteDomain);

    @Mapping(source = "tipoCozinha.codigo", target = "tipoCozinhaId")
    @Mapping(target = "itemCardapio", ignore = true)
    RestauranteDomain toRestauranteDomain(RestauranteEntity restauranteEntity);
}
