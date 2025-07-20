package com.fiap.ms.restaurante.application.usecase.itemCardapio;

import com.fiap.ms.restaurante.application.gateways.ItensCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations.AtualizaItemCardapioUseCaseImpl;
import com.fiap.ms.restaurante.domain.model.ItensCardapioDomain;
import com.fiap.ms.restaurante.mocks.ItensCardapioMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AtualizaItemCardapioUseCaseImplTest {

    @InjectMocks
    private AtualizaItemCardapioUseCaseImpl atualizaItemCardapioUseCase;

    @Mock
    private ItensCardapio itensCardapio;

    @Test
    void atualizaItemCardapio() {
        // Arrange
        ItensCardapioDomain item = ItensCardapioMock.getItensCardapioDomainCompleto();
        when(itensCardapio.findById(item.getId())).thenReturn(Optional.of(item));
        doNothing().when(itensCardapio).salvar(item);

        // Act
        atualizaItemCardapioUseCase.atualiza(item.getId(), item);

        // Assert
        verify(itensCardapio, times(1)).findById(item.getId());
        verify(itensCardapio, times(1)).salvar(item);
    }

    @Test
    void atualizaItemCardapioNaoEncontrado() {

    }
}
