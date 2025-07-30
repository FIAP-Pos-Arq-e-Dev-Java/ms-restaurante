package com.fiap.ms.restaurante.application.gateways;

import com.fiap.ms.restaurante.domain.model.RestauranteDomain;

import java.util.List;
import java.util.Optional;

public interface Restaurante {

    void deletar(RestauranteDomain restauranteDomain);

    void salvar(RestauranteDomain restauranteDomain);

    Optional<RestauranteDomain> buscarPorId(Long id);

    Boolean findRestaurantByIdUser(Long idUser);

    List<RestauranteDomain> buscar(String nome, String endereco, String horarioFuncionamento);
}
