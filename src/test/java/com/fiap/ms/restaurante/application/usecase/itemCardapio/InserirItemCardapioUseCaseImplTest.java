package com.fiap.ms.restaurante.application.usecase.itemCardapio;

import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations.InserirItemCardapioUseCaseImpl;
import com.fiap.ms.restaurante.domain.domainService.ItemCardapioDomainService;
import com.fiap.ms.restaurante.domain.exception.ObjetoJaExisteException;
import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.fiap.ms.restaurante.mocks.ItemCardapioMock.getItemCardapioDomainCompleto;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class InserirItemCardapioUseCaseImplTest {

    @InjectMocks
    private InserirItemCardapioUseCaseImpl inserirItemCardapioUseCase;

    @Mock
    private ItemCardapio itemCardapio;

    @Mock
    private ItemCardapioDomainService itemCardapioDomainService;

    @Test
    void deveSalvarItemCardapio_sucesso(){
        ItemCardapioDomain item = getItemCardapioDomainCompleto();

        doNothing().when(itemCardapioDomainService).checarExistenciaItem(item.getDescricao(), item.getRestauranteId(), item.getNome());
        doNothing().when(itemCardapio).salvar(item);

        inserirItemCardapioUseCase.inserir(item);

        verify(itemCardapioDomainService, times(1)).checarExistenciaItem(item.getDescricao(), item.getRestauranteId(), item.getNome());
        verify(itemCardapio, times(1)).salvar(item);
    }

    @Test
    void deveSalvarItemCardapio_descricaoExistente_objetoJaExisteException(){
        ItemCardapioDomain item = getItemCardapioDomainCompleto();

        doThrow(ObjetoJaExisteException.class).when(itemCardapioDomainService).checarExistenciaItem(item.getDescricao(), item.getRestauranteId(), item.getNome());

        assertThrows(ObjetoJaExisteException.class, () -> inserirItemCardapioUseCase.inserir(item));

        verify(itemCardapioDomainService, times(1)).checarExistenciaItem(item.getDescricao(), item.getRestauranteId(), item.getNome());
    }
}

