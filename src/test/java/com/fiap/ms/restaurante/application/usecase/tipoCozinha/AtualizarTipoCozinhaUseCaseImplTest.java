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

import java.util.UUID;

import static com.fiap.ms.restaurante.mocks.TipoCozinhaMock.getTipoCozinhaDomain;
import static com.fiap.ms.restaurante.mocks.TipoCozinhaMock.getTipoCozinhaDomainSemDescricao;
import static org.junit.Assert.assertThrows;
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

    }


    @Test
    void atualizarTipoCozinha_naoEncontrado_tipoCozinhaNaoExisteException() {
        UUID codigo = UUID.fromString("550e8400-e29b-41d4-a716-446655440000");
        TipoCozinhaDomain tipoCozinhaDomain = getTipoCozinhaDomain();

        when(tipoCozinhaDomainService.buscarTipoCozinhaPorCodigo(codigo)).thenThrow(new ObjetoNaoExisteException("Tipo cozinha não está cadastrada."));

        assertThrows(ObjetoNaoExisteException.class, () -> atualizarTipoCozinha.atualizar(codigo, tipoCozinhaDomain));

        verify(tipoCozinhaDomainService, times(1)).buscarTipoCozinhaPorCodigo(codigo);

    }

    @Test
    void atualizarTipoCozinha_descricaoNula_campoObrigatorioException() {
        UUID codigo = UUID.fromString("550e8400-e29b-41d4-a716-446655440000");
        TipoCozinhaDomain tipoCozinhaDomain = getTipoCozinhaDomainSemDescricao();

        assertThrows(CampoObrigatorioException.class, () -> atualizarTipoCozinha.atualizar(codigo, tipoCozinhaDomain));
    }


    @Test
    void atualizarTipoCozinha_descricaoExistente_tipoCozinhaNaoExisteException() {

    }

}
