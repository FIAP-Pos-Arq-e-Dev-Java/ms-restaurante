package com.fiap.ms.restaurante.application.usecase.tipoCozinha.implementations;

import com.fiap.ms.restaurante.application.gateways.TipoCozinha;
import com.fiap.ms.restaurante.application.usecase.tipoCozinha.AtualizarTipoCozinhaUseCase;
import com.fiap.ms.restaurante.domain.domainService.TipoCozinhaDomainService;
import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.fiap.ms.restaurante.domain.rules.ValidarDescricaoObrigatoriaRule.validar;

@RequiredArgsConstructor
@Service
public class AtualizarTipoCozinhaUseCaseImpl implements AtualizarTipoCozinhaUseCase {

    private final TipoCozinha tipoCozinha;
    private final TipoCozinhaDomainService tipoCozinhaDomainService;

    @Override
    public void atualizar(UUID codigo, TipoCozinhaDomain tipoCozinhaDomain) {
        validar(tipoCozinhaDomain.getDescricao());

        TipoCozinhaDomain domain = tipoCozinhaDomainService.buscarTipoCozinhaPorCodigo(codigo);
        tipoCozinhaDomainService.checarExistenciaDescricao(tipoCozinhaDomain.getDescricao());

        domain.setDescricao(tipoCozinhaDomain.getDescricao().trim());
        tipoCozinha.salvar(domain);
    }
}
