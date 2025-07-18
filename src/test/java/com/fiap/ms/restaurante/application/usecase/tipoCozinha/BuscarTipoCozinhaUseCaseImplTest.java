package com.fiap.ms.restaurante.application.usecase.tipoCozinha;

import com.fiap.ms.restaurante.application.gateways.TipoCozinha;
import com.fiap.ms.restaurante.application.usecase.tipoCozinha.implementations.BuscarTipoCozinhaUseCaseImpl;
import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.fiap.ms.restaurante.mocks.TipoCozinhaMock.getListTipoCozinhaDomain;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BuscarTipoCozinhaUseCaseImplTest {

    @InjectMocks
    private BuscarTipoCozinhaUseCaseImpl buscarTipoCozinhaUseCase;

    @Mock
    private TipoCozinha tipoCozinha;

    @Test
    void buscarTipoCozinha_semFiltros_sucesso() {
        List<TipoCozinhaDomain> listaTipoCozinha = getListTipoCozinhaDomain();

        when(tipoCozinha.buscar(null, null)).thenReturn(listaTipoCozinha);

        List<TipoCozinhaDomain> result = buscarTipoCozinhaUseCase.buscar(null, null);

        assertNotNull(result);
        assertEquals(listaTipoCozinha.size(), result.size());
        verify(tipoCozinha, times(1)).buscar(null, null);

    }

    @Test
    void buscarTipoCozinha_filtroCodigo_sucesso() {

    }

    @Test
    void buscarTipoCozinha_filtroDescricao_sucesso() {

    }

    @Test
    void buscarTipoCozinha_todosOsFiltros_sucesso() {

    }

    @Test
    void buscarTipoCozinha_semRetorno_sucesso() {

    }

}
