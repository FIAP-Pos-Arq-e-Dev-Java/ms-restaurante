package com.fiap.ms.restaurante.domain.domainService;

import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;

public interface ItemCardapioDomainService {

    void checarExistenciaDescricao(String descricao);
    ItemCardapioDomain buscarItemCardapioPorId(Long id);
}
