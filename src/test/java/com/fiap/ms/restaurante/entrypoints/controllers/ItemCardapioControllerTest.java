package com.fiap.ms.restaurante.entrypoints.controllers;

import com.fiap.ms.restaurante.application.usecase.itemCardapio.AtualizaItemCardapioUseCase;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.BuscaItemCardapioUseCase;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.DeletaItemCardapioUseCase;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.InserirItemCardapioUseCase;
import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
import com.fiap.ms.restauranteDomain.gen.model.ItemCardapioDto;
import com.fiap.ms.restauranteDomain.gen.model.ItemCardapioRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.fiap.ms.restaurante.mocks.ItemCardapioMock.getItemCardapioRequestDto;
import static com.fiap.ms.restaurante.mocks.ItemCardapioMock.getItensCardapioDomain;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemCardapioControllerTest {

    @InjectMocks
    private ItemCardapioController  controller;

    @Mock
    private InserirItemCardapioUseCase inserirItemCardapioUseCase;

    @Mock
    private BuscaItemCardapioUseCase buscaItemCardapioUseCase;

    @Mock
    private DeletaItemCardapioUseCase deletaItemCardapioUseCase;

    @Mock
    private AtualizaItemCardapioUseCase atualizaItemCardapioUseCase;

    @Test
    void _atualizarItemCardapio_sucesso() {
        Long id = 1L;
        ItemCardapioRequestDto itemCardapioRequestDto = getItemCardapioRequestDto();

        doNothing().when(atualizaItemCardapioUseCase).atualizar(any(Long.class), any());

        ResponseEntity<Void> response = controller._atualizarItemCardapio(id, itemCardapioRequestDto);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(atualizaItemCardapioUseCase, times(1)).atualizar(any(Long.class), any());
    }

    @Test
    void _buscarItensCardapio_sucesso() {
        String nome = "Pizza Margherita";
        Boolean disponibilidadeConsumoLocal = true;
        List<ItemCardapioDomain> itensCardapioDomain = getItensCardapioDomain();

        when(buscaItemCardapioUseCase.buscar(nome, disponibilidadeConsumoLocal)).thenReturn(itensCardapioDomain);

        ResponseEntity<List<ItemCardapioDto>> response = controller._buscarItensCardapio(nome, disponibilidadeConsumoLocal);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(buscaItemCardapioUseCase, times(1)).buscar(nome, disponibilidadeConsumoLocal);
    }

    @Test
    void _buscarItensCardapio_semParametros_sucesso() {
        List<ItemCardapioDomain> itensCardapioDomain = getItensCardapioDomain();

        when(buscaItemCardapioUseCase.buscar(null, null)).thenReturn(itensCardapioDomain);

        ResponseEntity<List<ItemCardapioDto>> response = controller._buscarItensCardapio(null, null);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(buscaItemCardapioUseCase, times(1)).buscar(null, null);
    }

    @Test
    void _deletarItemCardapio_sucesso() {
        Long id = 1L;
        doNothing().when(deletaItemCardapioUseCase).deletar(id);

        ResponseEntity<Void> response = controller._deletarItemCardapio(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(deletaItemCardapioUseCase, times(1)).deletar(id);
    }

    @Test
    void _inserirItemCardapio_sucesso() {
        ItemCardapioRequestDto itemCardapioRequestDto = getItemCardapioRequestDto();

        doNothing().when(inserirItemCardapioUseCase).inserir(any());

        ResponseEntity<Void> response = controller._inserirItemCardapio(itemCardapioRequestDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(inserirItemCardapioUseCase, times(1)).inserir(any());
    }
}
