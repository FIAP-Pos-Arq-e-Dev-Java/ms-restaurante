package com.fiap.ms.restaurante.entrypoints.controllers.mappers;

import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
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
    ItemCardapioDomain toItemCardapioDomain(ItemCardapioRequestDto itemCardapioRequestDto);

    ItemCardapioDto toItemCardapioDto(ItemCardapioDomain itemCardapioDomain);
}
