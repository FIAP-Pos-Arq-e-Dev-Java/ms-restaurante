package com.fiap.ms.restaurante.entrypoints.controllers.mappers;

import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteDto;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteRequestDto;
import com.fiap.ms.restauranteDomain.gen.model.UsuarioDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface RestauranteDtoMapper {

    RestauranteDtoMapper INSTANCE = Mappers.getMapper(RestauranteDtoMapper.class);

    @Mapping(target = "id", ignore = true)
    RestauranteDomain toDomain(RestauranteRequestDto restauranteRequestDto);

    RestauranteDto toRestauranteDto(RestauranteDomain restauranteDomain);

    // Método para converter UsuarioDto para UUID
    default UUID map(UsuarioDto usuarioDto) {
        if (usuarioDto == null) {
            return null;
        }
        return usuarioDto.getId();
    }

    // Método para converter UUID para UsuarioDto
    default UsuarioDto map(UUID usuarioId) {
        if (usuarioId == null) {
            return null;
        }
        UsuarioDto dto = new UsuarioDto();
        dto.setId(usuarioId);
        return dto;
    }
}
