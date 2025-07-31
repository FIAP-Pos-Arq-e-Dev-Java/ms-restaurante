package com.fiap.ms.restaurante.application.usecase.restaurante;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.application.usecase.restaurante.implementations.DeletarRestauranteUseCaseImpl;
import com.fiap.ms.restaurante.domain.domainService.RestauranteDomainService;
import com.fiap.ms.restaurante.domain.exception.ObjetoNaoExisteException;
import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.fiap.ms.restaurante.mocks.RestauranteMock.getRestauranteDomain;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeletarRestauranteUseCaseImplTest {

    @InjectMocks
    private DeletarRestauranteUseCaseImpl deletarRestauranteUseCaseImpl;

    @Mock
    private Restaurante restaurante;

    @Mock
    private RestauranteDomainService restauranteDomainService;

    private final Long ID = 1L;

    @Test
    void deletarRestaurante_sucesso() {
        RestauranteDomain restauranteDomain = getRestauranteDomain();

        when(restauranteDomainService.buscaRestaurantePorId(ID)).thenReturn(restauranteDomain);
        doNothing().when(restaurante).deletar(restauranteDomain);

        deletarRestauranteUseCaseImpl.deletar(ID);

        verify(restauranteDomainService, times(1)).buscaRestaurantePorId(ID);
        verify(restaurante, times(1)).deletar(restauranteDomain);
    }

    @Test
    void deletarRestaurante_idInvalido_objetoNaoExisteException() {
        when(restauranteDomainService.buscaRestaurantePorId(ID)).thenThrow(new ObjetoNaoExisteException("Restaurante não cadastrado."));

        assertThrows(ObjetoNaoExisteException.class, () -> deletarRestauranteUseCaseImpl.deletar(ID));

        verify(restauranteDomainService, times(1)).buscaRestaurantePorId(ID);
    }
}
