package com.fiap.ms.restaurante.application.usecase.tipoCozinha;

import com.fiap.ms.restaurante.application.gateways.TipoCozinha;
import com.fiap.ms.restaurante.application.usecase.tipoCozinha.implementations.AtualizarTipoCozinhaUseCaseImpl;
import com.fiap.ms.restaurante.domain.domainService.TipoCozinhaDomainService;
import com.fiap.ms.restaurante.domain.exception.CampoObrigatorioException;
import com.fiap.ms.restaurante.domain.exception.ObjetoNaoExisteException;
import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.fiap.ms.restaurante.mocks.TipoCozinhaMock.getTipoCozinhaDomain;
import static com.fiap.ms.restaurante.mocks.TipoCozinhaMock.getTipoCozinhaDomainSemDescricao;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AtualizarTipoCozinhaUseCaseImplTest {

    @InjectMocks
    private AtualizarTipoCozinhaUseCaseImpl atualizarTipoCozinha;

    @Mock
    private TipoCozinha tipoCozinha;

    @Mock
    private TipoCozinhaDomainService tipoCozinhaDomainService;

    @Test
    void atualizarTipoCozinha_sucesso() {
        TipoCozinhaDomain tipoCozinhaDomain = getTipoCozinhaDomain();
        when(tipoCozinhaDomainService.buscarTipoCozinhaPorCodigo(tipoCozinhaDomain.getCodigo())).thenReturn(tipoCozinhaDomain);
        doNothing().when(tipoCozinhaDomainService).checarExistenciaDescricao(tipoCozinhaDomain.getDescricao());
        doNothing().when(tipoCozinha).salvar(tipoCozinhaDomain);

        atualizarTipoCozinha.atualizar(tipoCozinhaDomain.getCodigo(), tipoCozinhaDomain);

        verify(tipoCozinhaDomainService, times(1)).buscarTipoCozinhaPorCodigo(tipoCozinhaDomain.getCodigo());
        verify(tipoCozinhaDomainService, times(1)).checarExistenciaDescricao(tipoCozinhaDomain.getDescricao());
        verify(tipoCozinha, times(1)).salvar(tipoCozinhaDomain);
    }

    @Test
    void atualizarTipoCozinha_naoEncontrado_tipoCozinhaNaoExisteException() {
        Long codigo = 1L;
        TipoCozinhaDomain tipoCozinhaDomain = getTipoCozinhaDomain();

        when(tipoCozinhaDomainService.buscarTipoCozinhaPorCodigo(codigo)).thenThrow(new ObjetoNaoExisteException("Tipo cozinha não está cadastrada."));

        assertThrows(ObjetoNaoExisteException.class, () -> atualizarTipoCozinha.atualizar(codigo, tipoCozinhaDomain));

        verify(tipoCozinhaDomainService, times(1)).buscarTipoCozinhaPorCodigo(codigo);
    }

    @Test
    void atualizarTipoCozinha_descricaoNula_campoObrigatorioException() {
        Long codigo = 1L;
        TipoCozinhaDomain tipoCozinhaDomain = getTipoCozinhaDomainSemDescricao();

        assertThrows(CampoObrigatorioException.class, () -> atualizarTipoCozinha.atualizar(codigo, tipoCozinhaDomain));
    }
}