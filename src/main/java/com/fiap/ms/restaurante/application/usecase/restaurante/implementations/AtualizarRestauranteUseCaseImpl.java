package com.fiap.ms.restaurante.application.usecase.restaurante.implementations;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.application.usecase.restaurante.AtualizarRestauranteUseCase;
import com.fiap.ms.restaurante.domain.domainService.RestauranteDomainService;
import com.fiap.ms.restaurante.domain.domainService.TipoCozinhaDomainService;
import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;

import java.util.Objects;

public class AtualizarRestauranteUseCaseImpl implements AtualizarRestauranteUseCase {

    private final Restaurante restaurante;
    private final RestauranteDomainService  restauranteDomainService;
    private final TipoCozinhaDomainService tipoCozinhaDomainService;

    public AtualizarRestauranteUseCaseImpl(Restaurante restaurante,
                                           RestauranteDomainService  restauranteDomainService,
                                           TipoCozinhaDomainService tipoCozinhaDomainService) {
        this.restaurante = restaurante;
        this.restauranteDomainService = restauranteDomainService;
        this.tipoCozinhaDomainService = tipoCozinhaDomainService;
    }

    @Override
    public void atualizar(Long id, RestauranteDomain restauranteDomain) {
        RestauranteDomain domain = restauranteDomainService.buscaRestaurantePorId(id);

        TipoCozinhaDomain tipoCozinhaDomain = tipoCozinhaDomainService.buscarTipoCozinhaPorCodigo(restauranteDomain.getTipoCozinha().getCodigo());

        if(Objects.nonNull(tipoCozinhaDomain)) {

            domain.setNome(restauranteDomain.getNome());
            domain.setEndereco(restauranteDomain.getEndereco());
            domain.setHorarioFuncionamento(restauranteDomain.getHorarioFuncionamento());

            restauranteDomain.setTipoCozinha(tipoCozinhaDomain);

            restaurante.salvar(restauranteDomain);
        }
    }
}
