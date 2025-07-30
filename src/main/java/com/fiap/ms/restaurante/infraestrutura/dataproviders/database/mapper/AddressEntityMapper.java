package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.mapper;

import com.fiap.ms.restaurante.domain.model.AddressDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AddressEntityMapper {

    AddressEntityMapper INSTANCE = Mappers.getMapper(AddressEntityMapper.class);

    AddressEntity toAddressEntity(AddressDomain addressDomain);

    AddressDomain toAddressDomain(AddressEntity addressEntity);
}
