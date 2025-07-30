package com.fiap.ms.restaurante.application.usecase.address;

import com.fiap.ms.restaurante.domain.model.AddressDomain;

public interface UpdateAddressUseCase {

    void update(Long id, AddressDomain addressDomain);
}
