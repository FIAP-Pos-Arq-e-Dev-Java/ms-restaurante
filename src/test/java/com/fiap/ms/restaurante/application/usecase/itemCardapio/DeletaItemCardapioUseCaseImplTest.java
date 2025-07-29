package com.fiap.ms.restaurante.application.usecase.itemCardapio;

import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations.DeletaItemCardapioUseCaseImpl;
import com.fiap.ms.restaurante.domain.domainService.ItemCardapioDomainService;
import com.fiap.ms.restaurante.domain.exception.ObjetoNaoExisteException;
import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.fiap.ms.restaurante.mocks.ItemCardapioMock.getItemCardapioDomainCompleto;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeletaItemCardapioUseCaseImplTest {

    @InjectMocks
    private DeletaItemCardapioUseCaseImpl deletaItemCardapioUseCase;

    @Mock
    private ItemCardapio itemCardapio;

    @Mock
    private ItemCardapioDomainService itemCardapioDomainService;

    @Test
    void deletaItemCardapio_sucesso(){
        Long id = 1L;

        ItemCardapioDomain item = getItemCardapioDomainCompleto();
        when(itemCardapioDomainService.buscarItemCardapioPorId(id)).thenReturn(item);
        doNothing().when(itemCardapio).deletar(item);

        deletaItemCardapioUseCase.deletar(id);

        verify(itemCardapioDomainService, times(1)).buscarItemCardapioPorId(id);
        verify(itemCardapio, times(1)).deletar(item);
    }

    @Test
    void deletaItemCardapio_idInexistente_objetoNaoExisteException() {
        Long id = 1L;

        when(itemCardapioDomainService.buscarItemCardapioPorId(id)).thenThrow(ObjetoNaoExisteException.class);

        assertThrows(ObjetoNaoExisteException.class, () -> deletaItemCardapioUseCase.deletar(id));

        verify(itemCardapioDomainService, times(1)).buscarItemCardapioPorId(id);
    }
}
