package com.fiap.ms.restaurante.application.gateways;

import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TipoCozinha {

    void deletar(TipoCozinhaDomain tipoCozinhaDomain);

    void salvar(TipoCozinhaDomain tipoCozinhaDomain);

    Optional<TipoCozinhaDomain> buscarPorCodigo(UUID codigo);

    Optional<TipoCozinhaDomain> buscarPorDescricao(String descricao);

    List<TipoCozinhaDomain> buscar(UUID codigo, String descricao);
}
