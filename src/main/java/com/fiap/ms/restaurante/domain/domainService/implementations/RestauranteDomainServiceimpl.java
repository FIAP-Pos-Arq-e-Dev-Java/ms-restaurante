package com.fiap.ms.restaurante.domain.domainService.implementations;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.domain.domainService.RestauranteDomainService;
import com.fiap.ms.restaurante.domain.exception.ObjetoJaExisteException;
import com.fiap.ms.restaurante.domain.exception.ObjetoNaoExisteException;
import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RestauranteDomainServiceimpl implements RestauranteDomainService {

    private final Restaurante restaurante;

    @Override
    public RestauranteDomain buscaRestaurantePorId(Long id) {
        return restaurante.buscarPorId(id)
                .orElseThrow(() -> new ObjetoNaoExisteException("Restaurante não cadastrado."));
    }

    @Override
    public void checarExistenciaNome(String nome) {
        if (restaurante.buscarPorNome(nome.trim()).isPresent()) {
            throw new ObjetoJaExisteException("Nome de Restaurante já cadastrado.");
        }
    }
}
