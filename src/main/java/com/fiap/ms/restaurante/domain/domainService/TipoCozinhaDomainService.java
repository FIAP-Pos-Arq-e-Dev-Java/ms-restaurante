package com.fiap.ms.restaurante.domain.domainService;

import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;

import java.util.UUID;

public interface TipoCozinhaDomainService {

    void checarExistenciaCodigo(UUID codigo);
    void checarExistenciaDescricao(String descricao);
    TipoCozinhaDomain buscarTipoCozinhaPorCodigo(UUID codigo);
}
