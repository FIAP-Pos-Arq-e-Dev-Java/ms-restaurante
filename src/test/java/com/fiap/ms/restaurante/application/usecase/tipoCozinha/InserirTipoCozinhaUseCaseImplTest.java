package com.fiap.ms.restaurante.application.usecase.tipoCozinha;

import com.fiap.ms.restaurante.application.gateways.TipoCozinha;
import com.fiap.ms.restaurante.application.usecase.tipoCozinha.implementations.InserirTipoCozinhaUseCaseImpl;
import com.fiap.ms.restaurante.domain.domainService.TipoCozinhaDomainService;
import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.fiap.ms.restaurante.mocks.TipoCozinhaMock.getTipoCozinhaDomain;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class InserirTipoCozinhaUseCaseImplTest {

    @InjectMocks
    private InserirTipoCozinhaUseCaseImpl inserirTipoCozinhaUseCase;

    @Mock
    private TipoCozinhaDomainService tipoCozinhaDomainService;

    @Mock
    private TipoCozinha tipoCozinha;

    @Test
    void inserirTipoCozinha_sucesso(){
        TipoCozinhaDomain tipoCozinhaDomain = getTipoCozinhaDomain();

        doNothing().when(tipoCozinhaDomainService).checarExistenciaCodigo(tipoCozinhaDomain.getCodigo());
        doNothing().when(tipoCozinhaDomainService).checarExistenciaDescricao(tipoCozinhaDomain.getDescricao());
        doNothing().when(tipoCozinha).salvar(tipoCozinhaDomain);

        inserirTipoCozinhaUseCase.inserir(tipoCozinhaDomain);

        verify(tipoCozinhaDomainService, times(1)).checarExistenciaCodigo(tipoCozinhaDomain.getCodigo());
        verify(tipoCozinhaDomainService, times(1)).checarExistenciaDescricao(tipoCozinhaDomain.getDescricao());
        verify(tipoCozinha, times(1)).salvar(tipoCozinhaDomain);
    }

}
