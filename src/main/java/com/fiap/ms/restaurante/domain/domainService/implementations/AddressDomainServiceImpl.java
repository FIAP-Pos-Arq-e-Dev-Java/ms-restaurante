package com.fiap.ms.restaurante.domain.domainService.implementations;

import com.fiap.ms.restaurante.application.gateways.Address;
import com.fiap.ms.restaurante.domain.domainService.AddressDomainService;
import com.fiap.ms.restaurante.domain.exception.ObjetoNaoExisteException;
import com.fiap.ms.restaurante.domain.model.AddressDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressDomainServiceImpl implements AddressDomainService {

    private Address address;

    @Override
    public AddressDomain findAddressById(Long id) {
        return address.findById(id)
                .orElseThrow(() -> new ObjetoNaoExisteException("O endereço não esta cadastrado"));
    }
}
