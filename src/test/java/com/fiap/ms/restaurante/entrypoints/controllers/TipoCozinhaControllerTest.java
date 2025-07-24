package com.fiap.ms.restaurante.entrypoints.controllers;

import com.fiap.ms.restaurante.application.usecase.tipoCozinha.AtualizarTipoCozinhaUseCase;
import com.fiap.ms.restaurante.application.usecase.tipoCozinha.BuscarTipoCozinhaUseCase;
import com.fiap.ms.restaurante.application.usecase.tipoCozinha.DeletarTipoCozinhaUseCase;
import com.fiap.ms.restaurante.application.usecase.tipoCozinha.InserirTipoCozinhaUseCase;
import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import com.fiap.ms.restauranteDomain.gen.model.TipoCozinhaDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.fiap.ms.restaurante.mocks.TipoCozinhaMock.getListTipoCozinhaDomain;
import static com.fiap.ms.restaurante.mocks.TipoCozinhaMock.getTipoCozinhaDto;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TipoCozinhaControllerTest {

    @InjectMocks
    private TipoCozinhaController controller;

    @Mock
    private InserirTipoCozinhaUseCase inserirTipoCozinhaUseCase;

    @Mock
    private DeletarTipoCozinhaUseCase deletarTipoCozinhaUseCase;

    @Mock
    private AtualizarTipoCozinhaUseCase atualizarTipoCozinhaUseCase;

    @Mock
    private BuscarTipoCozinhaUseCase buscarTipoCozinhaUseCase;

    @Test
    void _atualizarTipoCozinha_sucesso() {
        Long codigo = 1L;
        TipoCozinhaDto tipoCozinhaDto = getTipoCozinhaDto();

        doNothing().when(atualizarTipoCozinhaUseCase).atualizar(anyLong(), any());

        ResponseEntity<Void> response = controller._atualizarTipoCozinha(codigo, tipoCozinhaDto);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(atualizarTipoCozinhaUseCase, times(1)).atualizar(anyLong(), any());
    }

    @Test
    void _buscarTiposCozinhas_sucesso() {
        Long codigo = 1L;
        String descricao = "Brasileira";
        List<TipoCozinhaDomain> tipoCozinhaDomain = getListTipoCozinhaDomain();

        when(buscarTipoCozinhaUseCase.buscar(codigo, descricao)).thenReturn(tipoCozinhaDomain);

        ResponseEntity<List<TipoCozinhaDto>> response = controller._buscarTiposCozinhas(codigo, descricao);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(buscarTipoCozinhaUseCase, times(1)).buscar(codigo, descricao);
    }

    @Test
    void _buscarTiposCozinhas_semParametros_sucesso() {
        List<TipoCozinhaDomain> tipoCozinhaDomain = getListTipoCozinhaDomain();

        when(buscarTipoCozinhaUseCase.buscar(null, null)).thenReturn(tipoCozinhaDomain);

        ResponseEntity<List<TipoCozinhaDto>> response = controller._buscarTiposCozinhas(null, null);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(buscarTipoCozinhaUseCase, times(1)).buscar(null, null);
    }

    @Test
    void _deletarTipoCozinha_sucesso() {
        Long codigo = 1L;
        doNothing().when(deletarTipoCozinhaUseCase).deletar(codigo);

        ResponseEntity<Void> response = controller._deletarTipoCozinha(codigo);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(deletarTipoCozinhaUseCase, times(1)).deletar(codigo);
    }

    @Test
    void _inserirTipoCozinha_sucesso() {
        TipoCozinhaDto tipoCozinhaDto = getTipoCozinhaDto();

        doNothing().when(inserirTipoCozinhaUseCase).inserir(any());

        ResponseEntity<Void> response = controller._inserirTipoCozinha(tipoCozinhaDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(inserirTipoCozinhaUseCase, times(1)).inserir(any());
    }
}
