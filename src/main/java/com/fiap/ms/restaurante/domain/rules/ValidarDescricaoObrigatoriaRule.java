package com.fiap.ms.restaurante.domain.rules;

import com.fiap.ms.restaurante.domain.exception.CampoObrigatorioException;

public final class ValidarDescricaoObrigatoriaRule {

    public static void validarDescricaoObrigatoria(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new CampoObrigatorioException("Existem campos obrigatórios que não foram preenchidos.");
        }
    }
}
