package com.fiap.ms.restaurante.application.usecase.tipoCozinha.implementations;

import com.fiap.ms.restaurante.application.gateways.TipoCozinha;
import com.fiap.ms.restaurante.application.usecase.tipoCozinha.InserirTipoCozinhaUseCase;
import com.fiap.ms.restaurante.domain.domainService.TipoCozinhaDomainService;
import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;

import static com.fiap.ms.restaurante.domain.rules.ValidarDescricaoObrigatoriaRule.validarDescricaoObrigatoria;

public class InserirTipoCozinhaUseCaseImpl implements InserirTipoCozinhaUseCase {

    private final TipoCozinha tipoCozinha;
    private final TipoCozinhaDomainService tipoCozinhaDomainService;

    public InserirTipoCozinhaUseCaseImpl(TipoCozinha tipoCozinha,
                                         TipoCozinhaDomainService tipoCozinhaDomainService) {
        this.tipoCozinha = tipoCozinha;
        this.tipoCozinhaDomainService = tipoCozinhaDomainService;
    }

    @Override
    public void inserir(TipoCozinhaDomain tipoCozinhaDomain) {
        validarDescricaoObrigatoria(tipoCozinhaDomain.getDescricao());

        tipoCozinhaDomainService.checarExistenciaCodigo(tipoCozinhaDomain.getCodigo());
        tipoCozinhaDomainService.checarExistenciaDescricao(tipoCozinhaDomain.getDescricao());

        tipoCozinhaDomain.setDescricao(tipoCozinhaDomain.getDescricao().trim());
        tipoCozinha.salvar(tipoCozinhaDomain);
    }
}
