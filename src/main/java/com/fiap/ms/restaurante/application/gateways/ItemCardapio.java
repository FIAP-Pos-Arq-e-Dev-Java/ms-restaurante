package com.fiap.ms.restaurante.application.gateways;

import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;

import java.util.List;
import java.util.Optional;

public interface ItemCardapio {

    void salvar(ItemCardapioDomain item);

    Optional<ItemCardapioDomain> buscarPorId(Long id);

    List<ItemCardapioDomain> buscarTodos(String nome, Boolean disponibilidadeConsumoLocal);

    void deletar(ItemCardapioDomain item);

    Optional<ItemCardapioDomain> buscarPorDescricaoERestauranteIdENome(String descricao, Long restauranteId, String nome);
}
