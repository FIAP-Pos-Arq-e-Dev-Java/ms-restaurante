package com.fiap.ms.restaurante.application.usecase.itemCardapio;

import com.fiap.ms.restaurante.application.gateways.ItensCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations.BuscaItemCardapioUseCaseImpl;
import com.fiap.ms.restaurante.domain.model.ItensCardapioDomain;
import com.fiap.ms.restaurante.mocks.ItensCardapioMock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BuscaItemCardapioUseCaseImplTest {

    @InjectMocks()
    private BuscaItemCardapioUseCaseImpl buscaItemCardapioUseCase;

    @Mock
    private ItensCardapio itensRepository;

    @Test
    void buscarTodosItensCardapio() {
        //Arrange
        List<ItensCardapioDomain> itens = ItensCardapioMock.getItensCardapioDomain();
        when(itensRepository.buscarTodos(null, null)).thenReturn(itens);

        //Act
        List<ItensCardapioDomain> itemResult = itensRepository.buscarTodos(null, null);

        //Assert
        assertNotNull(itemResult);
        assertEquals(itens.size(), itemResult.size());
        verify(itensRepository, times(1)).buscarTodos(null, null);
    }

    @Test
    void buscaItensCardapioPeloNome(){
        //Arrange
        List<ItensCardapioDomain> itens = ItensCardapioMock.getItensCardapioDomain();
        when(itensRepository.buscarTodos("Pizza Margherita", null)).thenReturn(itens);

        //Act
        List<ItensCardapioDomain> itensResult = itensRepository.buscarTodos("Pizza Margherita", null);

        //Assert
        assertNotNull(itensResult);
        assertEquals(itens.size(), itensResult.size());
        verify(itensRepository, times(1)).buscarTodos("Pizza Margherita", null);
    }

    @Test
    void buscaItensCardapioPeloDisponibilidade(){
        //Arrange
//        List<ItensCardapioDomain> itens = ItensCardapioMock.getItensCardapioDomain();
//        when(itensRepository.buscarTodos(null, "Apenas no Restaurante")).thenReturn(itens);
//
//        //Act
//        List<ItensCardapioDomain> itensResult = itensRepository.buscarTodos(null, "Apenas no Restaurante");
//
//        //Assert
//        assertNotNull(itensResult);
//        assertEquals(itens.size(), itensResult.size());
//        verify(itensRepository, times(1)).buscarTodos(null, "Apenas no Restaurante");
    }

}
