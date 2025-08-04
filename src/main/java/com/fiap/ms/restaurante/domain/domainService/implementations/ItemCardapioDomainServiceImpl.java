package com.fiap.ms.restaurante.domain.domainService.implementations;

import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
import com.fiap.ms.restaurante.domain.domainService.ItemCardapioDomainService;
import com.fiap.ms.restaurante.domain.exception.ObjetoJaExisteException;
import com.fiap.ms.restaurante.domain.exception.ObjetoNaoExisteException;
import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemCardapioDomainServiceImpl implements ItemCardapioDomainService {

    private final ItemCardapio itemCardapio;

    @Override
    public void checarExistenciaItem(String descricao, Long restauranteId, String nome) {
        if (itemCardapio.buscarPorDescricaoERestauranteIdENome(descricao.trim(), restauranteId, nome).isPresent()) {
            throw new ObjetoJaExisteException("Código ou Descrição do item de cardápio já cadastrado.");
        }
    }

    @Override
    public ItemCardapioDomain buscarItemCardapioPorId(Long id) {
        return itemCardapio.buscarPorId(id)
                .orElseThrow(() -> new ObjetoNaoExisteException("O item de cardápio informado não está cadastrado."));
    }
}