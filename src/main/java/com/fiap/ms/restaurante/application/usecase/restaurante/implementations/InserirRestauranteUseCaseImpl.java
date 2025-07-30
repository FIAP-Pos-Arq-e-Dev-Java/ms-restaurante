package com.fiap.ms.restaurante.application.usecase.restaurante.implementations;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.application.usecase.restaurante.InserirRestauranteUseCase;
import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import com.fiap.ms.restaurante.domain.rules.ExtrairUserIdDoTokenRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InserirRestauranteUseCaseImpl implements InserirRestauranteUseCase {

    private final Restaurante restaurante;

    @Override
    public void inserir(RestauranteDomain restauranteDomain) {
        Long userId = ExtrairUserIdDoTokenRule.obterUserId();
        restauranteDomain.setUsuarioId(userId);

        restaurante.salvar(restauranteDomain);
    }
}
