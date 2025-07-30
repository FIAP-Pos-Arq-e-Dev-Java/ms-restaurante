package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.implementations;

import com.fiap.ms.restaurante.application.gateways.Address;
import com.fiap.ms.restaurante.domain.model.AddressDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.mapper.AddressEntityMapper;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.repositories.AddressRepository;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.specification.AddressSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AddressImpl implements Address {

    private final AddressRepository repository;

    @Override
    public void save(AddressDomain addres) {
        var entity = AddressEntityMapper.INSTANCE.toAddressEntity(addres);
        repository.save(entity);
    }

    @Override
    public Optional<AddressDomain> findById(Long id) {
        var entity = repository.findById(id);
        return Optional.of(AddressEntityMapper.INSTANCE.toAddressDomain(entity.get()));
    }

    @Override
    public List<AddressDomain> findAll(String cidade, String estado) {
        var spec = AddressSpecification.filter(cidade, estado);
        return repository.findAll(spec)
                .stream()
                .map(AddressEntityMapper.INSTANCE::toAddressDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(AddressDomain item) {
        var entity = AddressEntityMapper.INSTANCE.toAddressEntity(item);
        repository.delete(entity);
    }
}
