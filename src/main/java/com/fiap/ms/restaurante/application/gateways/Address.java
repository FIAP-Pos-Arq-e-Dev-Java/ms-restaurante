package com.fiap.ms.restaurante.application.gateways;

import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;

import java.util.List;
import java.util.Optional;

public interface Address {

    void save(ItemCardapioDomain item);

    Optional<ItemCardapioDomain> findById(Long id);

    List<ItemCardapioDomain> findAll(String nome, Boolean disponibilidadeConsumoLocal);

    void delete(ItemCardapioDomain item);

    Optional<ItemCardapioDomain> findByDescription(String descricao);
}
