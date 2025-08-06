package com.fiap.ms.restaurante.entrypoints.controllers.mappers;

import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
import com.fiap.ms.restauranteDomain.gen.model.ItemCardapioDto;
import com.fiap.ms.restauranteDomain.gen.model.ItemCardapioRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ItemCardapioDtoMapper {

    ItemCardapioDtoMapper INSTANCE = Mappers.getMapper(ItemCardapioDtoMapper.class);

    @Mapping(target = "id", ignore = true)
    ItemCardapioDomain toItemCardapioDomain(ItemCardapioRequestDto dto);

    ItemCardapioDto toItemCardapioDto(ItemCardapioDomain domain);

    List<ItemCardapioDto> toListItemCardapioDto(List<ItemCardapioDomain> domains);
}
