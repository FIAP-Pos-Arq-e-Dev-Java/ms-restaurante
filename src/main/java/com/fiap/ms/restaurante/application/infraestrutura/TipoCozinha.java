package com.fiap.ms.restaurante.application.infraestrutura;

import com.fiap.ms.restaurante.application.domain.TipoCozinhaDomain;

import java.util.List;
import java.util.Optional;

public interface TipoCozinha {

    void deletar(TipoCozinhaDomain tipoCozinhaDomain);

    void salvar(TipoCozinhaDomain tipoCozinhaDomain);

    Optional<TipoCozinhaDomain> buscarPorCodigo(Long codigo);

    List<TipoCozinhaDomain> buscar(Long codigo, String descricao);
}
