package com.fiap.ms.restaurante.entrypoints.controllers.mappers;

import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import com.fiap.ms.restauranteDomain.gen.model.TipoCozinhaDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TipoCozinhaDtoMapper {

    TipoCozinhaDtoMapper INSTANCE = Mappers.getMapper(TipoCozinhaDtoMapper.class);

    TipoCozinhaDomain toDomain(TipoCozinhaDto tipoCozinhaDto);

    TipoCozinhaDto toTipoCozinhaDto(TipoCozinhaDomain tipoCozinhaDomain);

    List<TipoCozinhaDto> toListTipoCozinhaDto(List<TipoCozinhaDomain> tipoCozinhaDomainList);
}