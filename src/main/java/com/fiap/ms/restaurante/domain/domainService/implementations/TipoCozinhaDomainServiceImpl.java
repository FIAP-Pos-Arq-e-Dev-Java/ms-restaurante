package com.fiap.ms.restaurante.domain.domainService.implementations;

import com.fiap.ms.restaurante.application.gateways.TipoCozinha;
import com.fiap.ms.restaurante.domain.exception.ObjetoJaExisteException;
import com.fiap.ms.restaurante.domain.exception.ObjetoNaoExisteException;
import com.fiap.ms.restaurante.domain.domainService.TipoCozinhaDomainService;
import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TipoCozinhaDomainServiceImpl implements TipoCozinhaDomainService {

    private final TipoCozinha tipoCozinha;

    @Override
    public void checarExistenciaCodigo(UUID codigo) {
        if (tipoCozinha.buscarPorCodigo(codigo).isPresent()) {
            throw new ObjetoJaExisteException("Código ou Descrição do Tipo cozinha já cadastrado.");
        }
    }

    @Override
    public void checarExistenciaDescricao(String descricao) {
        if (tipoCozinha.buscarPorDescricao(descricao.trim()).isPresent()) {
            throw new ObjetoJaExisteException("Código ou Descrição do Tipo cozinha já cadastrado.");
        }
    }

    @Override
    public TipoCozinhaDomain buscarTipoCozinhaPorCodigo(UUID codigo) {
        return tipoCozinha.buscarPorCodigo(codigo)
                .orElseThrow(() -> new ObjetoNaoExisteException("Tipo cozinha não está cadastrada."));
    }
}
