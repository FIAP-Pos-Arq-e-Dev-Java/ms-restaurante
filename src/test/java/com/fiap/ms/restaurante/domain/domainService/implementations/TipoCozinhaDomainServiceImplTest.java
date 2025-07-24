package com.fiap.ms.restaurante.domain.domainService.implementations;

import com.fiap.ms.restaurante.application.gateways.TipoCozinha;
import com.fiap.ms.restaurante.domain.exception.ObjetoJaExisteException;
import com.fiap.ms.restaurante.domain.exception.ObjetoNaoExisteException;
import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.fiap.ms.restaurante.mocks.TipoCozinhaMock.getTipoCozinhaDomain;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TipoCozinhaDomainServiceImplTest {

    @InjectMocks
    private TipoCozinhaDomainServiceImpl tipoCozinhaDomainService;

    @Mock
    private TipoCozinha tipoCozinha;

    @Test
    void checarExistenciaCodigo_codigoExistente_objetoJaExisteException() {
        TipoCozinhaDomain tipoCozinhaDomain = getTipoCozinhaDomain();
        when(tipoCozinha.buscarPorCodigo(anyLong())).thenReturn(Optional.of(tipoCozinhaDomain));

        assertThrows(ObjetoJaExisteException.class, () -> tipoCozinhaDomainService.checarExistenciaCodigo(1L));

        verify(tipoCozinha).buscarPorCodigo(anyLong());
    }

    @Test
    void checarExistenciaCodigo_codigoNaoExistente_sucesso() {
        when(tipoCozinha.buscarPorCodigo(anyLong())).thenReturn(Optional.empty());

        tipoCozinhaDomainService.checarExistenciaCodigo(1L);

        verify(tipoCozinha).buscarPorCodigo(anyLong());
    }

    @Test
    void checarExistenciaDescricao_descricaoExistente_objetoJaExisteException() {
        TipoCozinhaDomain tipoCozinhaDomain = getTipoCozinhaDomain();
        when(tipoCozinha.buscarPorDescricao(anyString())).thenReturn(Optional.of(tipoCozinhaDomain));

        assertThrows(ObjetoJaExisteException.class, () -> tipoCozinhaDomainService.checarExistenciaDescricao("Brasileira"));

        verify(tipoCozinha).buscarPorDescricao(anyString());
    }

    @Test
    void checarExistenciaDescricao_descricaoNaoExistente_sucesso() {
        when(tipoCozinha.buscarPorDescricao(anyString())).thenReturn(Optional.empty());

        tipoCozinhaDomainService.checarExistenciaDescricao("Brasileira");

        verify(tipoCozinha).buscarPorDescricao(anyString());
    }

    @Test
    void buscarTipoCozinhaPorCodigo_codigoExistente_ObjetoNaoExisteException() {
        when(tipoCozinha.buscarPorCodigo(anyLong())).thenReturn(Optional.empty());

        assertThrows(ObjetoNaoExisteException.class, () -> tipoCozinhaDomainService.buscarTipoCozinhaPorCodigo(10L));

        verify(tipoCozinha).buscarPorCodigo(anyLong());
    }

    @Test
    void buscarTipoCozinhaPorCodigo_codigoNaoExistente_sucesso() {
        TipoCozinhaDomain tipoCozinhaDomain = getTipoCozinhaDomain();

        when(tipoCozinha.buscarPorCodigo(anyLong())).thenReturn(Optional.of(tipoCozinhaDomain));

        tipoCozinhaDomainService.buscarTipoCozinhaPorCodigo(tipoCozinhaDomain.getCodigo());

        verify(tipoCozinha).buscarPorCodigo(anyLong());
    }

}
