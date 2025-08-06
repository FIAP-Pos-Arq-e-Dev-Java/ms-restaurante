package com.fiap.ms.restaurante.entrypoints.controllers.presenter;

import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
import com.fiap.ms.restaurante.entrypoints.controllers.mappers.ItemCardapioDtoMapper;
import com.fiap.ms.restauranteDomain.gen.model.ItemCardapioDto;
import com.fiap.ms.restauranteDomain.gen.model.ItemCardapioRequestDto;

import java.util.List;

public class ItemCardapioPresenter {

    public static ItemCardapioDomain toItemCardapioDomain(ItemCardapioRequestDto itemCardapioRequestDto) {
        return ItemCardapioDtoMapper.INSTANCE.toItemCardapioDomain(itemCardapioRequestDto);
    }

    public static List<ItemCardapioDto> toListItemCardapioDto(List<ItemCardapioDomain> domains) {
        return ItemCardapioDtoMapper.INSTANCE.toListItemCardapioDto(domains);
    }
}
