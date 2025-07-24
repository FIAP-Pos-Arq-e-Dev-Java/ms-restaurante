package com.fiap.ms.restaurante.application.usecase.tipoCozinha.implementations;

import com.fiap.ms.restaurante.application.gateways.TipoCozinha;
import com.fiap.ms.restaurante.application.usecase.tipoCozinha.DeletarTipoCozinhaUseCase;
import com.fiap.ms.restaurante.domain.domainService.TipoCozinhaDomainService;
import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeletarTipoCozinhaUseCaseImpl implements DeletarTipoCozinhaUseCase {

    private final TipoCozinha tipoCozinha;
    private final TipoCozinhaDomainService tipoCozinhaDomainService;

    @Override
    public void deletar(Long codigo) {
        TipoCozinhaDomain domain = tipoCozinhaDomainService.buscarTipoCozinhaPorCodigo(codigo);
        tipoCozinha.deletar(domain);
    }
}
