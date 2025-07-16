package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.mapper;

import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.TipoCozinhaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TipoCozinhaEntityMapper {

    TipoCozinhaEntityMapper INSTANCE = Mappers.getMapper(TipoCozinhaEntityMapper.class);

    TipoCozinhaEntity toTipoCozinhaEntity(TipoCozinhaDomain domain);

    TipoCozinhaDomain toTipoCozinhaDomain(TipoCozinhaEntity entity);

    List<TipoCozinhaDomain> toListTipoCozinhaDomain(List<TipoCozinhaEntity> entities);

}
