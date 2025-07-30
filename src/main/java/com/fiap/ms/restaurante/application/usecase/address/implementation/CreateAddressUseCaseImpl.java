package com.fiap.ms.restaurante.application.usecase.address.implementation;

import com.fiap.ms.restaurante.application.gateways.Address;
import com.fiap.ms.restaurante.application.usecase.address.CreateAddressUseCase;
import com.fiap.ms.restaurante.domain.model.AddressDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateAddressUseCaseImpl implements CreateAddressUseCase {

    private final Address address;

    @Override
    public void createAddress(AddressDomain addressDomain) {
        // Adicionar as valida~çoes

        address.save(addressDomain);
    }
}
