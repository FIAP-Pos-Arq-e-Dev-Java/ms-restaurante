package com.fiap.ms.restaurante.application.usecase.address.implementation;

import com.fiap.ms.restaurante.application.gateways.Address;
import com.fiap.ms.restaurante.application.usecase.address.UpdateAddressUseCase;
import com.fiap.ms.restaurante.domain.domainService.AddressDomainService;
import com.fiap.ms.restaurante.domain.model.AddressDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateAddressUseCaseImpl implements UpdateAddressUseCase {

    private final Address address;
    private final AddressDomainService addressDomainService;

    @Override
    public void update(Long id, AddressDomain addressDomain) {
        //Adicionar uma validacao

        AddressDomain domain = addressDomainService.findAddressById(id);

        domain.setCity(addressDomain.getCity());
        domain.setStreet(addressDomain.getStreet());
        domain.setComplement(addressDomain.getComplement());
        domain.setNumber(addressDomain.getNumber());
        domain.setState(addressDomain.getState());
        address.save(domain);
    }
}
