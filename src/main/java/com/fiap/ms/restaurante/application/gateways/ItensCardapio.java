package com.fiap.ms.restaurante.application.gateways;


import com.fiap.ms.restaurante.domain.model.ItensCardapioDomain;

import java.util.List;
import java.util.Optional;

public interface ItensCardapio {

    void salvar(ItensCardapioDomain item);

    Optional<ItensCardapioDomain> findById(Long id);

    List<ItensCardapioDomain> buscarTodos(String nome, Boolean disponivelSomenteNoRestaurante);

    void deletar(ItensCardapioDomain item);
}
