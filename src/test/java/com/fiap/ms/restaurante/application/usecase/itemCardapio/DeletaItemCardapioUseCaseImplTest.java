package com.fiap.ms.restaurante.application.usecase.itemCardapio;

import com.fiap.ms.restaurante.application.gateways.ItensCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations.DeletaItemCardapioUseCaseImpl;
import com.fiap.ms.restaurante.domain.model.ItensCardapioDomain;
import com.fiap.ms.restaurante.mocks.ItensCardapioMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DeletaItemCardapioUseCaseImplTest {

    @InjectMocks
    private DeletaItemCardapioUseCaseImpl itensCardapioUseCaseImpl;

    @Mock
    private ItensCardapio itensCardapio;

    @Test
    void deletaItemCardapio(){
        // Arrange
        ItensCardapioDomain item = ItensCardapioMock.getItensCardapioDomainCompleto();
        when(itensCardapio.findById(1L)).thenReturn(Optional.of(item));
        doNothing().when(itensCardapio).deletar(item);

        // Act
        itensCardapioUseCaseImpl.deletar(1L);

        // Assert
        verify(itensCardapio, times(1)).findById(1L);
        verify(itensCardapio, times(1)).deletar(item);
    }

    @Test
    void deveLancarExcecaoQuandoItemNaoExiste() {
        // Arrange
        Long id = 1L;
        when(itensCardapio.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> itensCardapioUseCaseImpl.deletar(id));

        assertEquals("Item cardápio inexistente", exception.getMessage());

        verify(itensCardapio, times(1)).findById(id);
        verify(itensCardapio, never()).deletar(any());
    }
}
