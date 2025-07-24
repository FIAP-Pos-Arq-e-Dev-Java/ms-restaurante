package com.fiap.ms.restaurante.application.gateways;

import com.fiap.ms.restaurante.domain.model.RestauranteDomain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Restaurante {

    void deletar(RestauranteDomain restauranteDomain);

    void salvar(RestauranteDomain restauranteDomain);

    Optional<RestauranteDomain> buscarPorId(UUID id);

    List<RestauranteDomain> buscar(String nome, String endereco, String horarioFuncionamento);
}
