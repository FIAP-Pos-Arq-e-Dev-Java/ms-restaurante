package com.fiap.ms.restaurante.application.usecase.restaurante.implementations;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.application.usecase.restaurante.BuscaRestauranteUsuarioIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BuscaRestauranteUsuarioIdUseCaseImpl implements BuscaRestauranteUsuarioIdUseCase {

    private final Restaurante restaurante;

    @Override
    public Boolean findRestaurantByIdUser(Long idUser) {
        return restaurante.findRestaurantByIdUser(idUser);
    }
}
