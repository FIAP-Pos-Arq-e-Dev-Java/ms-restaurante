package com.fiap.ms.restaurante.entrypoints.controllers.mappers;

import com.fiap.ms.restaurante.domain.model.ItensCardapioDomain;
import com.fiap.ms.restauranteDomain.gen.model.ItemCardapioDto;
import com.fiap.ms.restauranteDomain.gen.model.ItemCardapioRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ItensCardapioDtoMapper {

    ItensCardapioDtoMapper INSTANCE = Mappers.getMapper(ItensCardapioDtoMapper.class);

    @Mapping(target = "id", ignore = true)
    ItensCardapioDomain toDomain(ItemCardapioRequestDto itemCardapioRequestDto);

    ItemCardapioDto toDto(ItensCardapioDomain itemCardapioDomain);
}
