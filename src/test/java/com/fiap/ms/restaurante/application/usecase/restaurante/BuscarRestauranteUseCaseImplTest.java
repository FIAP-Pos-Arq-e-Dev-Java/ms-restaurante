package com.fiap.ms.restaurante.application.usecase.restaurante;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.application.usecase.restaurante.implementations.BuscarRestauranteUseCaseImpl;
import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static com.fiap.ms.restaurante.mocks.RestauranteMock.getListRestauranteDomain;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BuscarRestauranteUseCaseImplTest {

    @InjectMocks
    private BuscarRestauranteUseCaseImpl buscarRestauranteUseCase;

    @Mock
    private Restaurante restaurante;

    @Test
    void buscarRestaurante_semFiltros_sucesso() {
        List<RestauranteDomain> restauranteDomains = getListRestauranteDomain();

        when(restaurante.buscar(null, null, null)).thenReturn(restauranteDomains);

        List<RestauranteDomain> result = buscarRestauranteUseCase.buscar(null, null, null);

        assertNotNull(result);
        assertEquals(restauranteDomains.size(), result.size());
        verify(restaurante, times(1)).buscar(null, null, null);
    }

    @Test
    void buscarRestaurante_filtroNome_sucesso() {
        String nome = "Churrascaria";
        RestauranteDomain restauranteDomains = new RestauranteDomain(1L, "Churrascaria do Zé", null, null, "11:00 - 22:00", 1L, Collections.emptyList());


        when(restaurante.buscar(nome, null, null)).thenReturn(List.of(restauranteDomains));

        List<RestauranteDomain> result = buscarRestauranteUseCase.buscar(nome, null, null);

        assertNotNull(result);
        assertEquals(List.of(restauranteDomains).size(), result.size());
        verify(restaurante, times(1)).buscar(nome, null, null);
    }

    @Test
    void buscarRestaurante_filtroUsuarioId_sucesso() {
        Long usuarioId = 1L;
        List<RestauranteDomain> restauranteDomains = getListRestauranteDomain();

        when(restaurante.buscar(null, usuarioId, null)).thenReturn(restauranteDomains);

        List<RestauranteDomain> result = buscarRestauranteUseCase.buscar(null, usuarioId, null);

        assertNotNull(result);
        assertEquals(restauranteDomains.size(), result.size());
        verify(restaurante, times(1)).buscar(null, usuarioId, null);
    }

    @Test
    void buscarRestaurante_filtroHorarioFuncionamento_sucesso() {
        String horarioFuncionamento = "11:00 - 22:00";
        List<RestauranteDomain> restauranteDomains = getListRestauranteDomain();

        when(restaurante.buscar(null, null, horarioFuncionamento)).thenReturn(restauranteDomains);

        List<RestauranteDomain> result = buscarRestauranteUseCase.buscar(null, null, horarioFuncionamento);

        assertNotNull(result);
        assertEquals(restauranteDomains.size(), result.size());
        verify(restaurante, times(1)).buscar(null, null, horarioFuncionamento);
    }

    @Test
    void buscarRestaurante_todosFiltros_sucesso() {
        String nome = "Churrascaria";
        Long usuarioId = 1L;
        String horarioFuncionamento = "11:00 - 22:00";
        List<RestauranteDomain> restauranteDomains = getListRestauranteDomain();

        when(restaurante.buscar(nome, usuarioId, horarioFuncionamento)).thenReturn(restauranteDomains);

        List<RestauranteDomain> result = buscarRestauranteUseCase.buscar(nome, usuarioId, horarioFuncionamento);

        assertNotNull(result);
        assertEquals(restauranteDomains.size(), result.size());
        verify(restaurante, times(1)).buscar(nome, usuarioId, horarioFuncionamento);
    }
}
