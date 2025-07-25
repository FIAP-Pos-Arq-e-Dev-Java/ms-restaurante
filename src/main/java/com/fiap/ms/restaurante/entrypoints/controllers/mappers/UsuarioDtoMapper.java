package com.fiap.ms.restaurante.entrypoints.controllers.mappers;

import com.fiap.ms.restaurante.domain.model.UsuarioDomain;
import com.fiap.ms.restauranteDomain.gen.model.UsuarioDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UsuarioDtoMapper {

    UsuarioDomain toDomain(UsuarioDto dto);

    UsuarioDto toDto(UsuarioDomain domain);
}