package com.fiap.ms.restaurante.application.gateways;

import com.fiap.ms.restaurante.domain.model.AddressDomain;

import java.util.List;
import java.util.Optional;

public interface Address {

    void save(AddressDomain addres);

    Optional<AddressDomain> findById(Long id);

    List<AddressDomain> findAll(String cidade, String estado);

    void delete(AddressDomain item);
}
