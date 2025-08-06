package com.fiap.ms.restaurante.entrypoints.controllers.presenter;

import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import com.fiap.ms.restaurante.entrypoints.controllers.mappers.TipoCozinhaDtoMapper;
import com.fiap.ms.restauranteDomain.gen.model.TipoCozinhaDto;

import java.util.List;

public class TipoCozinhaPresenter {

    public static TipoCozinhaDomain toDomain(TipoCozinhaDto tipoCozinhaDto) {
        return TipoCozinhaDtoMapper.INSTANCE.toDomain(tipoCozinhaDto);
    }

    public static List<TipoCozinhaDto> toListTipoCozinhaDto(List<TipoCozinhaDomain> domains) {
        return TipoCozinhaDtoMapper.INSTANCE.toListTipoCozinhaDto(domains);
    }
}
