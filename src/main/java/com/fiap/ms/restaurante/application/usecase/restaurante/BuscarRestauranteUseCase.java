package com.fiap.ms.restaurante.application.usecase.restaurante;

import com.fiap.ms.restaurante.domain.model.RestauranteDomain;

import java.util.List;

public interface BuscarRestauranteUseCase {

    List<RestauranteDomain> buscar(String nome, String endereco, String horarioFuncionamento);
}
