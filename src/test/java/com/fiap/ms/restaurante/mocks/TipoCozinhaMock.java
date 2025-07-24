package com.fiap.ms.restaurante.mocks;

import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.TipoCozinhaEntity;
import com.fiap.ms.restauranteDomain.gen.model.TipoCozinhaDto;

import java.util.List;

public class TipoCozinhaMock {

    public static TipoCozinhaDomain getTipoCozinhaDomain() {
        return new TipoCozinhaDomain(1L, "Brasileira");
    }

    public static TipoCozinhaDomain getTipoCozinhaDomainSemDescricao() {
        return new TipoCozinhaDomain(1L, "   ");
    }

    public static List<TipoCozinhaDomain> getListTipoCozinhaDomain() {
        TipoCozinhaDomain tipoCozinha1 = new TipoCozinhaDomain(1L, "Italiana");
        TipoCozinhaDomain tipoCozinha2 = new TipoCozinhaDomain(2L, "Francesa");
        return List.of(tipoCozinha1, tipoCozinha2);
    }

    public static TipoCozinhaEntity getTipoCozinhaEntity() {
        return new TipoCozinhaEntity(1L, "Brasileira");
    }

    public static List<TipoCozinhaEntity> getListTipoCozinhaEntity() {
        TipoCozinhaEntity tipoCozinhaEntity1 = new TipoCozinhaEntity(1L, "Italiana");
        TipoCozinhaEntity tipoCozinhaEntity2 = new TipoCozinhaEntity(2L, "Francesa");
        return List.of(tipoCozinhaEntity1, tipoCozinhaEntity2);
    }

    public static TipoCozinhaDto getTipoCozinhaDto() {
        TipoCozinhaDto tipoCozinhaDto = new TipoCozinhaDto();
        tipoCozinhaDto.setCodigo(1L);
        tipoCozinhaDto.setDescricao("Brasileira");
        return tipoCozinhaDto;
    }
}
