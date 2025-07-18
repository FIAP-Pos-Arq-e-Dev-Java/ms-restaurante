package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.mapper;

import com.fiap.ms.restaurante.domain.model.ItensCardapioDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.ItensCardapioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ItensCardapioEntityMapper {

    ItensCardapioEntityMapper INSTANCE = Mappers.getMapper(ItensCardapioEntityMapper.class);

    ItensCardapioEntity toItensCardapioEntity(ItensCardapioDomain itensCardapio);

    ItensCardapioDomain toItensCardapioDomain(ItensCardapioEntity itensCardapioEntity);
}
