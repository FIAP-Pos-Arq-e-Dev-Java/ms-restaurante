package com.fiap.ms.restaurante.domain.domainService.implementations;

import com.fiap.ms.restaurante.application.gateways.TipoCozinha;
import com.fiap.ms.restaurante.domain.exception.TipoCozinhaJaExisteException;
import com.fiap.ms.restaurante.domain.exception.TipoCozinhaNaoExisteException;
import com.fiap.ms.restaurante.domain.domainService.TipoCozinhaDomainService;
import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TipoCozinhaDomainServiceImpl implements TipoCozinhaDomainService {

    private final TipoCozinha tipoCozinha;

    @Override
    public void checarExistenciaCodigo(Long codigo) {
        if (tipoCozinha.buscarPorCodigo(codigo).isPresent()) {
            throw new TipoCozinhaJaExisteException();
        }
    }

    @Override
    public void checarExistenciaDescricao(String descricao) {
        if (tipoCozinha.buscarPorDescricao(descricao.trim()).isPresent()) {
            throw new TipoCozinhaJaExisteException();
        }
    }

    @Override
    public TipoCozinhaDomain buscarTipoCozinhaPorCodigo(Long codigo) {
        return tipoCozinha.buscarPorCodigo(codigo)
                .orElseThrow(TipoCozinhaNaoExisteException::new);
    }
}
