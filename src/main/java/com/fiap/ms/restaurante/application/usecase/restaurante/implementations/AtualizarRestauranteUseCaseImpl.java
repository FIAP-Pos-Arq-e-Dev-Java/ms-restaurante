package com.fiap.ms.restaurante.application.usecase.restaurante.implementations;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.application.usecase.restaurante.AtualizarRestauranteUseCase;
import com.fiap.ms.restaurante.domain.domainService.RestauranteDomainService;
import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AtualizarRestauranteUseCaseImpl implements AtualizarRestauranteUseCase {

    private final Restaurante restaurante;
    private final RestauranteDomainService  restauranteDomainService;

    @Override
    public void atualizar(Long id, RestauranteDomain restauranteDomain) {
        RestauranteDomain domain = restauranteDomainService.buscaRestaurantePorId(id);

        domain.setNome(restauranteDomain.getNome());
        domain.setEndereco(restauranteDomain.getEndereco());
        domain.setHorarioFuncionamento(restauranteDomain.getHorarioFuncionamento());
        domain.setTipoCozinha(restauranteDomain.getTipoCozinha());
        restaurante.salvar(domain);
    }
}
