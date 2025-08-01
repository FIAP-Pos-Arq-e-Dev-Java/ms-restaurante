package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.mapper;

import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.ItemCardapioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ItemCardapioEntityMapper {

    ItemCardapioEntityMapper INSTANCE = Mappers.getMapper(ItemCardapioEntityMapper.class);

    @Mapping(source = "restauranteId", target = "restaurante.id")
    ItemCardapioEntity toItemCardapioEntity(ItemCardapioDomain itemCardapioDomain);

    @Mapping(source = "restaurante.id", target = "restauranteId")
    ItemCardapioDomain toItemCardapioDomain(ItemCardapioEntity itemCardapioEntity);
}
