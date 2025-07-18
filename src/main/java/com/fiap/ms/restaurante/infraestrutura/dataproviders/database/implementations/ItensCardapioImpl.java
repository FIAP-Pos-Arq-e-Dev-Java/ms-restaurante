package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.implementations;

import com.fiap.ms.restaurante.application.gateways.ItensCardapio;
import com.fiap.ms.restaurante.domain.model.ItensCardapioDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.mapper.ItensCardapioEntityMapper;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.repositories.ItensCardapioRepository;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.specification.ItensCardapioSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ItensCardapioImpl implements ItensCardapio {

    private final ItensCardapioRepository repository;

    @Override
    public void salvar(ItensCardapioDomain item) {
        var entity = ItensCardapioEntityMapper.INSTANCE.toItensCardapioEntity(item);
        repository.save(entity);
    }

    @Override
    public Optional<ItensCardapioDomain> findById(Long id) {
        var entity = repository.findById(id);
        return Optional.of(ItensCardapioEntityMapper.INSTANCE.toItensCardapioDomain(entity.get()));
    }

    @Override
    public List<ItensCardapioDomain> buscarTodos(String nome, Boolean disponivelSomenteNoRestaurante) {
        var spec = ItensCardapioSpecification.filtrar(nome, disponivelSomenteNoRestaurante);
        return repository.findAll(spec)
                .stream()
                .map(ItensCardapioEntityMapper.INSTANCE::toItensCardapioDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deletar(ItensCardapioDomain itens) {
        var entity = ItensCardapioEntityMapper.INSTANCE.toItensCardapioEntity(itens);
        repository.delete(entity);
    }
}
