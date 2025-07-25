package com.fiap.ms.restaurante.application.usecase.restaurante.implementations;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.application.usecase.restaurante.BuscarRestauranteUseCase;
import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BuscarRestauranteUseCaseImpl implements BuscarRestauranteUseCase {

    private final Restaurante restaurante;

    @Override
    public List<RestauranteDomain> buscar(String nome, String endereco, String horarioFuncionamento) {
        return restaurante.buscar(nome, endereco, horarioFuncionamento);
    }
}
