package com.fiap.ms.restaurante.entrypoints.controllers.mappers;

import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteDto;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface RestauranteDtoMapper {

    RestauranteDtoMapper INSTANCE = Mappers.getMapper(RestauranteDtoMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuarioId", ignore = true)
    @Mapping(target = "itemCardapio", ignore = true)
    @Mapping(target = "tipoCozinha", source = "tipoCozinha")
    RestauranteDomain toRestauranteDomain(RestauranteRequestDto restauranteRequestDto);

    RestauranteDto toRestauranteDto(RestauranteDomain restauranteDomain);

    List<RestauranteDto> toListRestauranteDto(List<RestauranteDomain> restauranteDomain);

    default  TipoCozinhaDomain codigoTipoCozinhaDomain(Long codigo) {
        if (codigo == null) {
            return null;
        }

        TipoCozinhaDomain tipoCozinhaDomain = new TipoCozinhaDomain();
        tipoCozinhaDomain.setCodigo(codigo);
        return tipoCozinhaDomain;
    }
}
