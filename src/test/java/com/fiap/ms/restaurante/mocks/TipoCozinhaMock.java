package com.fiap.ms.restaurante.mocks;

import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.TipoCozinhaEntity;

import java.util.List;
import java.util.UUID;

public class TipoCozinhaMock {

    public static TipoCozinhaDomain getTipoCozinhaDomain() {
        return new TipoCozinhaDomain(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"), "Brasileira");
    }

    public static TipoCozinhaDomain getTipoCozinhaDomainSemDescricao() {
        return new TipoCozinhaDomain(UUID.fromString("00000000-0000-0000-0000-000000000099"), "   ");
    }

    public static List<TipoCozinhaDomain> getListTipoCozinhaDomain() {
        TipoCozinhaDomain tipoCozinha1 = new TipoCozinhaDomain(UUID.fromString("11111111-1111-1111-1111-111111111111"), "Italiana");
        TipoCozinhaDomain tipoCozinha2 = new TipoCozinhaDomain(UUID.fromString("22222222-2222-2222-2222-222222222222"), "Francesa");
        return List.of(tipoCozinha1, tipoCozinha2);
    }

    public static TipoCozinhaEntity getTipoCozinhaEntity() {
        return new TipoCozinhaEntity(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"), "Brasileira");
    }

    public static List<TipoCozinhaEntity> getListTipoCozinhaEntity() {
        TipoCozinhaEntity tipoCozinhaEntity1 = new TipoCozinhaEntity(UUID.fromString("11111111-1111-1111-1111-111111111111"), "Italiana");
        TipoCozinhaEntity tipoCozinhaEntity2 = new TipoCozinhaEntity(UUID.fromString("22222222-2222-2222-2222-222222222222"), "Francesa");
        return List.of(tipoCozinhaEntity1, tipoCozinhaEntity2);
    }
}
