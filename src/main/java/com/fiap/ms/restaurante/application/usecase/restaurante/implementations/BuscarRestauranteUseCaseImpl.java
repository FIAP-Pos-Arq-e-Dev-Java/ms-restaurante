package com.fiap.ms.restaurante.application.usecase.restaurante.implementations;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.application.usecase.restaurante.BuscarRestauranteUseCase;
import com.fiap.ms.restaurante.domain.model.RestauranteDomain;

import java.util.List;

public class BuscarRestauranteUseCaseImpl implements BuscarRestauranteUseCase {

    private final Restaurante restaurante;

    public BuscarRestauranteUseCaseImpl(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    public List<RestauranteDomain> buscar(String nome, Long usuarioId, String horarioFuncionamento) {
        return restaurante.buscar(nome, usuarioId, horarioFuncionamento);
    }
}
