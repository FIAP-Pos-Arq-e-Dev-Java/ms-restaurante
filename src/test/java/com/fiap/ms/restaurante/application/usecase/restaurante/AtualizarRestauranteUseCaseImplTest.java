package com.fiap.ms.restaurante.application.usecase.restaurante;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.application.usecase.restaurante.implementations.AtualizarRestauranteUseCaseImpl;
import com.fiap.ms.restaurante.domain.domainService.RestauranteDomainService;
import com.fiap.ms.restaurante.domain.domainService.TipoCozinhaDomainService;
import com.fiap.ms.restaurante.domain.exception.ObjetoNaoExisteException;
import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.fiap.ms.restaurante.mocks.RestauranteMock.getRestauranteDomain;
import static com.fiap.ms.restaurante.mocks.TipoCozinhaMock.getTipoCozinhaDomain;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AtualizarRestauranteUseCaseImplTest {

    @InjectMocks
    private AtualizarRestauranteUseCaseImpl atualizarRestauranteUseCase;

    @Mock
    private Restaurante restaurante;

    @Mock
    private RestauranteDomainService restauranteDomainService;

    @Mock
    private TipoCozinhaDomainService tipoCozinhaDomainService;

    @Test
    void atualizarRestaurante_sucesso() {
        RestauranteDomain restauranteDomain = getRestauranteDomain();
        TipoCozinhaDomain tipoCozinhaDomain = getTipoCozinhaDomain();
        when(restauranteDomainService.buscaRestaurantePorId(restauranteDomain.getId())).thenReturn(restauranteDomain);
        when(tipoCozinhaDomainService.buscarTipoCozinhaPorCodigo(restauranteDomain.getId())).thenReturn(tipoCozinhaDomain);

        doNothing().when(restaurante).salvar(restauranteDomain);

        atualizarRestauranteUseCase.atualizar(restauranteDomain.getId(), restauranteDomain);

        verify(restauranteDomainService, times(1)).buscaRestaurantePorId(restauranteDomain.getId());
        verify(tipoCozinhaDomainService, times(1)).buscarTipoCozinhaPorCodigo(restauranteDomain.getId());
        verify(restaurante, times(1)).salvar(restauranteDomain);
    }

    @Test
    void atualizarRestaurante_idInexistente() {
        RestauranteDomain restauranteDomain = getRestauranteDomain();
        when(restauranteDomainService.buscaRestaurantePorId(restauranteDomain.getId())).thenReturn(restauranteDomain);

        atualizarRestauranteUseCase.atualizar(restauranteDomain.getId(), restauranteDomain);

        verify(restauranteDomainService, times(1)).buscaRestaurantePorId(restauranteDomain.getId());
    }

    @Test
    void atualizarRestaurante_idInvalido_objetoNaoExisteException() {
        Long id = 1L;
        RestauranteDomain restauranteDomain = getRestauranteDomain();

        when(restauranteDomainService.buscaRestaurantePorId(any())).thenThrow(new ObjetoNaoExisteException("Restaurante não cadastrado."));

        assertThrows(ObjetoNaoExisteException.class, () -> atualizarRestauranteUseCase.atualizar(id, restauranteDomain));

        verify(restauranteDomainService, times(1)).buscaRestaurantePorId(any());
    }
}
