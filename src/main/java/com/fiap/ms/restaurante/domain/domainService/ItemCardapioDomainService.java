package com.fiap.ms.restaurante.domain.domainService;

import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;

public interface ItemCardapioDomainService {

    void checarExistenciaItem(String descricao, Long restauranteId, String nome);
    ItemCardapioDomain buscarItemCardapioPorId(Long id);
}
