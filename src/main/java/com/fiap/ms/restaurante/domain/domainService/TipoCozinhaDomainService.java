package com.fiap.ms.restaurante.domain.domainService;

import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;

public interface TipoCozinhaDomainService {

    void checarExistenciaCodigo(Long codigo);
    void checarExistenciaDescricao(String descricao);
    TipoCozinhaDomain buscarTipoCozinhaPorCodigo(Long codigo);
}
