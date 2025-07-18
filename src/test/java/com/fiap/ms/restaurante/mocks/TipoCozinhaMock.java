package com.fiap.ms.restaurante.mocks;

import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.TipoCozinhaEntity;

import java.util.List;

public class TipoCozinhaMock {

    public static TipoCozinhaDomain getTipoCozinhaDomain() {
        return new TipoCozinhaDomain(1L, "Brasileira");
    }

    public static TipoCozinhaDomain getTipoCozinhaDomainSemDescricao() {
        return new TipoCozinhaDomain(99L, "   ");
    }

    public static List<TipoCozinhaDomain> getListTipoCozinhaDomain() {
        TipoCozinhaDomain tipoCozinha1 = new TipoCozinhaDomain(1L, "Italiana");
        TipoCozinhaDomain tipoCozinha2 = new TipoCozinhaDomain(2L, "Francesa");
        return List.of(tipoCozinha1, tipoCozinha2);
    }

    public static TipoCozinhaEntity getTipoCozinhaEntity() {
        return new TipoCozinhaEntity(1L, "Brasileira");
    }

}
