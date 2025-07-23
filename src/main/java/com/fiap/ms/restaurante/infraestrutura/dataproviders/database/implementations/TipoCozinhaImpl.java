package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.implementations;

import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import com.fiap.ms.restaurante.application.gateways.TipoCozinha;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.mapper.TipoCozinhaEntityMapper;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.repositories.TipoCozinhaRepository;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.specification.TipoCozinhaSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TipoCozinhaImpl implements TipoCozinha {

    private final TipoCozinhaRepository repository;

    @Override
    public void deletar(TipoCozinhaDomain tipoCozinhaDomain) {
        var entity = TipoCozinhaEntityMapper.INSTANCE.toTipoCozinhaEntity(tipoCozinhaDomain);
        repository.delete(entity);
    }

    @Override
    public void salvar(TipoCozinhaDomain tipoCozinhaDomain) {
        var entity = TipoCozinhaEntityMapper.INSTANCE.toTipoCozinhaEntity(tipoCozinhaDomain);
        repository.save(entity);
    }

    @Override
    public Optional<TipoCozinhaDomain> buscarPorCodigo(UUID codigo) {
        var entity = repository.findByCodigo(codigo);
        return entity.map(TipoCozinhaEntityMapper.INSTANCE::toTipoCozinhaDomain);
    }

    @Override
    public Optional<TipoCozinhaDomain> buscarPorDescricao(String descricao) {
        var entity = repository.findByDescricaoIgnoreCase(descricao);
        return entity.map(TipoCozinhaEntityMapper.INSTANCE::toTipoCozinhaDomain);
    }

    @Override
    public List<TipoCozinhaDomain> buscar(UUID codigo, String descricao) {
        var spec = TipoCozinhaSpecification.filtrar(codigo, descricao);
        return repository.findAll(spec)
                .stream()
                .map(TipoCozinhaEntityMapper.INSTANCE::toTipoCozinhaDomain)
                .toList();
    }
}
