package com.fiap.ms.restaurante.application.usecase.address.implementation;

import com.fiap.ms.restaurante.application.gateways.Address;
import com.fiap.ms.restaurante.application.usecase.address.FindAddressUseCase;
import com.fiap.ms.restaurante.domain.model.AddressDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindAddressUseCaseImpl implements FindAddressUseCase {

    private final Address address;

    @Override
    public List<AddressDomain> findAddress(String cidade, String estado) {
        return address.findAll(cidade, estado);
    }
}
