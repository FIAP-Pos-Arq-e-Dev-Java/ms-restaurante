package com.fiap.ms.restaurante.infraestrutura.dataproviders.config.usecase.tipoCozinha;

import com.fiap.ms.restaurante.application.gateways.TipoCozinha;
import com.fiap.ms.restaurante.application.usecase.tipoCozinha.implementations.DeletarTipoCozinhaUseCaseImpl;
import com.fiap.ms.restaurante.domain.domainService.TipoCozinhaDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarTipoCozinhaConfig {

    @Bean
    public DeletarTipoCozinhaUseCaseImpl deletarTipoCozinhaUseCase(TipoCozinha tipoCozinha,
                                                                   TipoCozinhaDomainService tipoCozinhaDomainService) {
        return new DeletarTipoCozinhaUseCaseImpl(tipoCozinha, tipoCozinhaDomainService);
    }
}
