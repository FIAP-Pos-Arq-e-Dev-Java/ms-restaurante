package com.fiap.ms.restaurante.domain.domainService.implementations;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.domain.exception.ObjetoNaoExisteException;
import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RestauranteDomainServiceimplTest {

    @InjectMocks
    private RestauranteDomainServiceimpl restauranteDomainService;

    @Mock
    private Restaurante restaurante;

    @Test
    void buscaRestaurantePorId_sucesso() {
        RestauranteDomain restauranteDomain = mock(RestauranteDomain.class);

        when(restaurante.buscarPorId(anyLong())).thenReturn(Optional.of(restauranteDomain));

        restauranteDomainService.buscaRestaurantePorId(1L);

        verify(restaurante, times(1)).buscarPorId(anyLong());
    }

    @Test
    void buscaRestaurantePorId_objetoNaoExisteException() {

        when(restaurante.buscarPorId(anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrows(ObjetoNaoExisteException.class, () -> restauranteDomainService.buscaRestaurantePorId(1L));

        verify(restaurante, times(1)).buscarPorId(anyLong());
    }

}
