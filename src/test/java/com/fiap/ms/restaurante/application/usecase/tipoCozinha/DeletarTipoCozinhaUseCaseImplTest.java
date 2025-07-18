package com.fiap.ms.restaurante.application.usecase.tipoCozinha;

import com.fiap.ms.restaurante.application.gateways.TipoCozinha;
import com.fiap.ms.restaurante.application.usecase.tipoCozinha.implementations.DeletarTipoCozinhaUseCaseImpl;
import com.fiap.ms.restaurante.domain.domainService.TipoCozinhaDomainService;
import com.fiap.ms.restaurante.domain.exception.TipoCozinhaNaoExisteException;
import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.fiap.ms.restaurante.mocks.TipoCozinhaMock.getTipoCozinhaDomain;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeletarTipoCozinhaUseCaseImplTest {

    private final Long CODIGO = 1L;

    @InjectMocks
    private DeletarTipoCozinhaUseCaseImpl deletarTipoCozinhaUseCase;

    @Mock
    private TipoCozinhaDomainService tipoCozinhaDomainService;

    @Mock
    private TipoCozinha tipoCozinha;

    @Test
    void deleteTipoCozinha_sucesso() {
        TipoCozinhaDomain tipoCozinhaDomain = getTipoCozinhaDomain();

        when(tipoCozinhaDomainService.buscarTipoCozinhaPorCodigo(CODIGO)).thenReturn(tipoCozinhaDomain);
        doNothing().when(tipoCozinha).deletar(tipoCozinhaDomain);

        deletarTipoCozinhaUseCase.deletar(CODIGO);

        verify(tipoCozinhaDomainService, times(1)).buscarTipoCozinhaPorCodigo(CODIGO);
        verify(tipoCozinha, times(1)).deletar(tipoCozinhaDomain);
    }

    @Test
    void deleteTipoCozinha_codigoInvalido_tipoCozinhaNaoExisteException() {
        when(tipoCozinhaDomainService.buscarTipoCozinhaPorCodigo(CODIGO)).thenThrow(new TipoCozinhaNaoExisteException());

        assertThrows(TipoCozinhaNaoExisteException.class, () -> deletarTipoCozinhaUseCase.deletar(CODIGO));

        verify(tipoCozinhaDomainService, times(1)).buscarTipoCozinhaPorCodigo(CODIGO);
    }
}
