package com.fiap.ms.restaurante.application.usecase.itemCardapio;

import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations.BuscarItemCardapioUseCaseImpl;
import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static com.fiap.ms.restaurante.mocks.ItemCardapioMock.getItensCardapioDomain;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BuscarItemCardapioUseCaseImplTest {

    @InjectMocks()
    private BuscarItemCardapioUseCaseImpl buscaItemCardapioUseCase;

    @Mock
    private ItemCardapio itemCardapio;

    @Test
    void buscarTodosItensCardapio_sucesso() {
        List<ItemCardapioDomain> itens = getItensCardapioDomain();
        when(itemCardapio.buscarTodos(null, null)).thenReturn(itens);

        List<ItemCardapioDomain> itemResult = buscaItemCardapioUseCase.buscar(null, null);

        assertNotNull(itemResult);
        assertEquals(itens.size(), itemResult.size());
        verify(itemCardapio, times(1)).buscarTodos(null, null);
    }

    @Test
    void buscarItensCardapioPeloNome_sucesso(){
        List<ItemCardapioDomain> itens = getItensCardapioDomain();
        when(itemCardapio.buscarTodos("Pizza Margherita", null)).thenReturn(itens);

        List<ItemCardapioDomain> itensResult = buscaItemCardapioUseCase.buscar("Pizza Margherita", null);

        assertNotNull(itensResult);
        assertEquals(itens.size(), itensResult.size());
        verify(itemCardapio, times(1)).buscarTodos("Pizza Margherita", null);
    }

    @Test
    void buscarItensCardapioPorNomeInexistente_sucesso(){
        when(itemCardapio.buscarTodos("Sorvete", null)).thenReturn(Collections.emptyList());

        List<ItemCardapioDomain> itensResult = buscaItemCardapioUseCase.buscar("Sorvete", null);

        assertTrue(itensResult.isEmpty());
        verify(itemCardapio, times(1)).buscarTodos("Sorvete", null);
    }

    @Test
    void buscarItensCardapioPeloDisponibilidadeConsumoLocal_sucesso(){
        List<ItemCardapioDomain> itens = getItensCardapioDomain();
        when(itemCardapio.buscarTodos(null, true)).thenReturn(itens);

        List<ItemCardapioDomain> itensResult = buscaItemCardapioUseCase.buscar(null, true);

        assertNotNull(itensResult);
        assertEquals(itens.size(), itensResult.size());
        assertEquals(itensResult.get(0).getFoto(), itens.get(0).getFoto());
        verify(itemCardapio, times(1)).buscarTodos(null, true);
    }

    @Test
    void buscarItensCardapioSemDisponibilidadeConsumoLocal_sucesso(){
        List<ItemCardapioDomain> itens = getItensCardapioDomain();
        when(itemCardapio.buscarTodos(null, false)).thenReturn(itens);

        List<ItemCardapioDomain> itensResult = buscaItemCardapioUseCase.buscar(null, false);

        assertNotNull(itensResult);
        assertEquals(itens.size(), itensResult.size());
        verify(itemCardapio, times(1)).buscarTodos(null, false);
    }
}