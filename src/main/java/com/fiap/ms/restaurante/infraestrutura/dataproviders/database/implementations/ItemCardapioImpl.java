package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.implementations;

import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.mapper.ItemCardapioEntityMapper;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.repositories.ItemCardapioRepository;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.specification.ItemCardapioSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ItemCardapioImpl implements ItemCardapio {

    private final ItemCardapioRepository repository;

    @Override
    public void salvar(ItemCardapioDomain item) {
        var entity = ItemCardapioEntityMapper.INSTANCE.toItemCardapioEntity(item);
        repository.save(entity);
    }

    @Override
    public Optional<ItemCardapioDomain> buscarPorId(Long id) {
        var entity = repository.findById(id);
        return Optional.of(ItemCardapioEntityMapper.INSTANCE.toItemCardapioDomain(entity.get()));
    }

    @Override
    public List<ItemCardapioDomain> buscarTodos(String nome, Boolean disponibilidadeConsumoLocal) {
        var spec = ItemCardapioSpecification.filtrar(nome, disponibilidadeConsumoLocal);
        return repository.findAll(spec)
                .stream()
                .map(ItemCardapioEntityMapper.INSTANCE::toItemCardapioDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deletar(ItemCardapioDomain itens) {
        var entity = ItemCardapioEntityMapper.INSTANCE.toItemCardapioEntity(itens);
        repository.delete(entity);
    }

    @Override
    public Optional<ItemCardapioDomain> buscarPorDescricao(String descricao) {
        var entity = repository.findByDescricaoIgnoreCase(descricao);
        return entity.map(ItemCardapioEntityMapper.INSTANCE::toItemCardapioDomain);
    }
}
