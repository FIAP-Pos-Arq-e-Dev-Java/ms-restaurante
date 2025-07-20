package com.fiap.ms.restaurante.application.usecase.itemCardapio;

import com.fiap.ms.restaurante.application.gateways.ItensCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations.InserirItemCardapioUseCaseImpl;
import com.fiap.ms.restaurante.domain.model.ItensCardapioDomain;
import com.fiap.ms.restaurante.mocks.ItensCardapioMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InserirItemCardapioUseCaseImplTest {

    @InjectMocks
    private InserirItemCardapioUseCaseImpl inserirItemCardapioUseCase;

    @Mock
    private ItensCardapio itensCardapio;

    @Test
    void deveSalvarItemCardapio(){
        //Arrange
        ItensCardapioDomain item = ItensCardapioMock.getItensCardapioDomainCompleto();

        //Act
        itensCardapio.salvar(item);

        //Assert
        verify(itensCardapio, times(1)).salvar(item);
    }
}
