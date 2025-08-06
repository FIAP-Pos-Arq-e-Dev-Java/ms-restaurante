package com.fiap.ms.restaurante.infraestrutura.dataproviders.config.usecase.restaurante;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.application.usecase.restaurante.implementations.BuscaRestauranteUsuarioIdUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscaRestauraanteUsuarioIdConfig {

    @Bean
    public BuscaRestauranteUsuarioIdUseCaseImpl buscaRestauranteUsuarioIdUseCase(Restaurante restaurante) {
        return new BuscaRestauranteUsuarioIdUseCaseImpl(restaurante);
    }
}
