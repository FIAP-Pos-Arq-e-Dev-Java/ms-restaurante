package com.fiap.ms.restaurante.entrypoints.controllers.mappers;

import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.ItemCardapioEntity;
import com.fiap.ms.restauranteDomain.gen.model.ItemCardapioDto;
import com.fiap.ms.restauranteDomain.gen.model.ItemCardapioRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ItemCardapioDtoMapper {

    ItemCardapioDtoMapper INSTANCE = Mappers.getMapper(ItemCardapioDtoMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "restaurante", target = "restauranteId")
    ItemCardapioDomain toItemCardapioDomain(ItemCardapioRequestDto dto);

    @Mapping(source = "restauranteId", target = "restaurante")
    ItemCardapioDto toItemCardapioDto(ItemCardapioDomain domain);
}
