package com.fiap.ms.restaurante.entrypoints.controllers.mappers;

import com.fiap.ms.restaurante.domain.model.AddressDomain;
import com.fiap.ms.restauranteDomain.gen.model.EnderecoDto;
import com.fiap.ms.restauranteDomain.gen.model.EnderecoRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AddressDtoMapper {

    AddressDtoMapper INSTANCE = Mappers.getMapper(AddressDtoMapper.class);

    @Mapping(target = "id", ignore = true)
    AddressDomain toAddressDomain(EnderecoRequestDto enderecoRequestDto);

    EnderecoDto toAddressDto(AddressDomain addressDomain);
}
