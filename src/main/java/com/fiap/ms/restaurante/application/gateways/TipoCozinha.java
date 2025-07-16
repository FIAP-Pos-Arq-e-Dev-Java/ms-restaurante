package com.fiap.ms.restaurante.application.gateways;

import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;

import java.util.List;
import java.util.Optional;

public interface TipoCozinha {

    void deletar(TipoCozinhaDomain tipoCozinhaDomain);

    void salvar(TipoCozinhaDomain tipoCozinhaDomain);

    Optional<TipoCozinhaDomain> buscarPorCodigo(Long codigo);

    Optional<TipoCozinhaDomain> buscarPorDescricao(String descricao);

    List<TipoCozinhaDomain> buscar(Long codigo, String descricao);
}
