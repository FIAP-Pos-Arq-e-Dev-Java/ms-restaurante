package com.fiap.ms.restaurante.infraestrutura.dataproviders.config.usecase.tipoCozinha;

import com.fiap.ms.restaurante.application.gateways.TipoCozinha;
import com.fiap.ms.restaurante.application.usecase.tipoCozinha.implementations.BuscarTipoCozinhaUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarTipoCozinhaConfig {

    @Bean
    public BuscarTipoCozinhaUseCaseImpl buscarTipoCozinhaUseCase(TipoCozinha tipoCozinha) {
        return new BuscarTipoCozinhaUseCaseImpl(tipoCozinha);
    }
}
