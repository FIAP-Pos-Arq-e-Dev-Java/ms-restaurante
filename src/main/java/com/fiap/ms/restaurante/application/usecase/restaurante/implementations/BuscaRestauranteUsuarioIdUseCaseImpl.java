package com.fiap.ms.restaurante.application.usecase.restaurante.implementations;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.application.usecase.restaurante.BuscaRestauranteUsuarioIdUseCase;

public class BuscaRestauranteUsuarioIdUseCaseImpl implements BuscaRestauranteUsuarioIdUseCase {

    private final Restaurante restaurante;

    public BuscaRestauranteUsuarioIdUseCaseImpl(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    public Boolean buscarUsuarioPorId(Long usuarioId) {
        return restaurante.buscarUsuarioPorId(usuarioId);
    }
}
