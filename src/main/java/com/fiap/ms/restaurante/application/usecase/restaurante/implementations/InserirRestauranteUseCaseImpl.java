package com.fiap.ms.restaurante.application.usecase.restaurante.implementations;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.application.usecase.restaurante.InserirRestauranteUseCase;
import com.fiap.ms.restaurante.domain.domainService.RestauranteDomainService;
import com.fiap.ms.restaurante.domain.domainService.TipoCozinhaDomainService;
import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import com.fiap.ms.restaurante.domain.rules.ExtrairUserIdDoTokenRule;

import java.util.Objects;

public class InserirRestauranteUseCaseImpl implements InserirRestauranteUseCase {

    private final Restaurante restaurante;
    private final RestauranteDomainService restauranteDomainService;
    private final TipoCozinhaDomainService tipoCozinhaDomainService;

    public InserirRestauranteUseCaseImpl(Restaurante restaurante,
                                         RestauranteDomainService restauranteDomainService,
                                         TipoCozinhaDomainService tipoCozinhaDomainService) {
        this.restaurante = restaurante;
        this.restauranteDomainService = restauranteDomainService;
        this.tipoCozinhaDomainService = tipoCozinhaDomainService;
    }

    @Override
    public void inserir(RestauranteDomain restauranteDomain) {
        Long userId = ExtrairUserIdDoTokenRule.obterUserId();

        restauranteDomainService.checarExistenciaNome(restauranteDomain.getNome());

        TipoCozinhaDomain tipoCozinhaDomain = tipoCozinhaDomainService.buscarTipoCozinhaPorCodigo(restauranteDomain.getTipoCozinha().getCodigo());

        if(Objects.nonNull(tipoCozinhaDomain)) {
            restauranteDomain.setTipoCozinha(tipoCozinhaDomain);
            restauranteDomain.setUsuarioId(userId);

            restaurante.salvar(restauranteDomain);
        }
    }
}
