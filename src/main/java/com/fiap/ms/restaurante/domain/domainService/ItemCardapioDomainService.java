package com.fiap.ms.restaurante.domain.domainService;

import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;

import java.util.UUID;

public interface ItemCardapioDomainService {

    void checarExistenciaDescricao(String descricao);
    ItemCardapioDomain buscarItemCardapioPorId(UUID id);
}
