package com.fiap.ms.restaurante.application.usecase.itemCardapio;

import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations.AtualizaItemCardapioUseCaseImpl;
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
public class AtualizaItemCardapioUseCaseImplTest {

    @InjectMocks
    private AtualizaItemCardapioUseCaseImpl atualizaItemCardapioUseCase;

    @Mock
    private ItemCardapio itemCardapio;

    @Mock
    private ItemCardapioDomainService itemCardapioDomainService;

    @Test
    void atualizaItemCardapio_sucesso() {
        ItemCardapioDomain item = getItemCardapioDomainCompleto();

        when(itemCardapioDomainService.buscarItemCardapioPorId(item.getId())).thenReturn(item);
        doNothing().when(itemCardapio).salvar(item);

        atualizaItemCardapioUseCase.atualiza(item.getId(), item);

        verify(itemCardapioDomainService, times(1)).buscarItemCardapioPorId(item.getId());
        verify(itemCardapio, times(1)).salvar(item);
    }

    @Test
    void atualizaItemCardapio_idInexistente_objetoNaoExisteException() {
        ItemCardapioDomain item = getItemCardapioDomainCompleto();

        when(itemCardapioDomainService.buscarItemCardapioPorId(item.getId())).thenThrow(ObjetoNaoExisteException.class);

        assertThrows(ObjetoNaoExisteException.class, () -> atualizaItemCardapioUseCase.atualiza(item.getId(), item));

        verify(itemCardapioDomainService, times(1)).buscarItemCardapioPorId(item.getId());
    }
}