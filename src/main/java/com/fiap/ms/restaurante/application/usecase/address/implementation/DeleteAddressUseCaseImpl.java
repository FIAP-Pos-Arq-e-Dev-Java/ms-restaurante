package com.fiap.ms.restaurante.application.usecase.address.implementation;

import com.fiap.ms.restaurante.application.gateways.Address;
import com.fiap.ms.restaurante.application.usecase.address.DeleteAddressUseCase;
import com.fiap.ms.restaurante.domain.domainService.AddressDomainService;
import com.fiap.ms.restaurante.domain.model.AddressDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteAddressUseCaseImpl implements DeleteAddressUseCase {

    private final Address address;
    private final AddressDomainService addressDomainService;

    @Override
    public void deleteAddress(Long id) {
        AddressDomain addressDomain = addressDomainService.findAddressById(id);
        address.delete(addressDomain);
    }
}
