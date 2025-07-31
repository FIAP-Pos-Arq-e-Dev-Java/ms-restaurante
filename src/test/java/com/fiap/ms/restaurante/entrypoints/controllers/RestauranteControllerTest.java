package com.fiap.ms.restaurante.entrypoints.controllers;

import com.fiap.ms.restaurante.application.usecase.restaurante.AtualizarRestauranteUseCase;
import com.fiap.ms.restaurante.application.usecase.restaurante.BuscaRestauranteUsuarioIdUseCase;
import com.fiap.ms.restaurante.application.usecase.restaurante.BuscarRestauranteUseCase;
import com.fiap.ms.restaurante.application.usecase.restaurante.DeletarRestauranteUseCase;
import com.fiap.ms.restaurante.application.usecase.restaurante.InserirRestauranteUseCase;
import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteDto;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteRequestDto;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteUserExistsResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.fiap.ms.restaurante.mocks.RestauranteMock.getListRestauranteDomain;
import static com.fiap.ms.restaurante.mocks.RestauranteMock.getRestauranteRequestDto;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RestauranteControllerTest {

    @InjectMocks
    private RestauranteController restauranteController;

    @Mock
    private InserirRestauranteUseCase inserirRestauranteUseCase;

    @Mock
    private BuscarRestauranteUseCase buscarRestauranteUseCase;

    @Mock
    private DeletarRestauranteUseCase deletarRestauranteUseCase;

    @Mock
    private AtualizarRestauranteUseCase atualizarRestauranteUseCase;

    @Mock
    private BuscaRestauranteUsuarioIdUseCase buscaRestauranteUsuarioIdUseCase;

    @Test
    void _atualizarRestaurante_sucesso() {
        Long codigo = 1L;
        RestauranteRequestDto restauranteRequestDto = getRestauranteRequestDto();

        doNothing().when(atualizarRestauranteUseCase).atualizar(anyLong(), any());

        ResponseEntity<Void> response = restauranteController._atualizarRestaurante(codigo, restauranteRequestDto);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(atualizarRestauranteUseCase, times(1)).atualizar(anyLong(), any());
    }

    @Test
    void __buscarRestaurante_sucesso() {
        String nome = "";
        Long usuarioId = 1L;
        String horarioFuncionamento = "";

        List<RestauranteDomain> restauranteDomains = getListRestauranteDomain();

        when(buscarRestauranteUseCase.buscar(nome, usuarioId, horarioFuncionamento)).thenReturn(restauranteDomains);

        ResponseEntity<List<RestauranteDto>> response = restauranteController._buscarRestaurante(nome, usuarioId, horarioFuncionamento);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(buscarRestauranteUseCase, times(1)).buscar(nome, usuarioId, horarioFuncionamento);
    }

    @Test
    void _buscarTiposCozinhas_semParametros_sucesso() {
        List<RestauranteDomain> restauranteDomains = getListRestauranteDomain();

        when(buscarRestauranteUseCase.buscar(null, null, null)).thenReturn(restauranteDomains);

        ResponseEntity<List<RestauranteDto>> response = restauranteController._buscarRestaurante(null, null, null);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(buscarRestauranteUseCase, times(1)).buscar(null, null, null);
    }

    @Test
    void __deletarRestaurante_sucesso() {
        Long codigo = 1L;
        doNothing().when(deletarRestauranteUseCase).deletar(codigo);

        ResponseEntity<Void> response = restauranteController._deletarRestaurante(codigo);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(deletarRestauranteUseCase, times(1)).deletar(codigo);
    }

    @Test
    void _inserirTipoCozinha_sucesso() {
        RestauranteRequestDto restauranteRequestDto = getRestauranteRequestDto();

        doNothing().when(inserirRestauranteUseCase).inserir(any());

        ResponseEntity<Void> response = restauranteController._inserirRestaurante(restauranteRequestDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(inserirRestauranteUseCase, times(1)).inserir(any());
    }

    @Test
    void _verificarExistenciaUsuarioRestaurante_sucesso() {
        Long usuarioId = 1L;

        when(buscaRestauranteUsuarioIdUseCase.buscarUsuarioPorId(any())).thenReturn(true);

        ResponseEntity<RestauranteUserExistsResponseDto> response = restauranteController._verificarExistenciaUsuarioRestaurante(usuarioId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(buscaRestauranteUsuarioIdUseCase, times(1)).buscarUsuarioPorId(any());

    }
}
