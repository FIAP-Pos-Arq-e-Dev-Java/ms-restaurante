package com.fiap.ms.restaurante.entrypoints.controllers.mappers;

import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteDto;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteRequestDto;
import com.fiap.ms.restauranteDomain.gen.model.TipoCozinhaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR, uses = {ItemCardapioDtoMapper.class})
public interface RestauranteDtoMapper {

    RestauranteDtoMapper INSTANCE = Mappers.getMapper(RestauranteDtoMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuarioId", ignore = true)
    @Mapping(target = "itemCardapio", ignore = true)
    @Mapping(source = "tipoCozinha", target = "tipoCozinhaId")
    RestauranteDomain toRestauranteDomain(RestauranteRequestDto restauranteRequestDto);

    @Mapping(source = "tipoCozinhaId", target = "tipoCozinha")
    RestauranteDto toRestauranteDto(RestauranteDomain restauranteDomain);

    // Métodos auxiliares de conversão
    default TipoCozinhaDto map(Long tipoCozinhaId) {
        if (tipoCozinhaId == null) {
            return null;
        }
        TipoCozinhaDto dto = new TipoCozinhaDto();
        dto.setCodigo(tipoCozinhaId);
        return dto;
    }

    default Long map(TipoCozinhaDto tipoCozinhaDto) {
        if (tipoCozinhaDto == null) {
            return null;
        }
        return tipoCozinhaDto.getCodigo();
    }
}
