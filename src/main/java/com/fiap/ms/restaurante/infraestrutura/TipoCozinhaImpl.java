package com.fiap.ms.restaurante.infraestrutura;

import com.fiap.ms.restaurante.application.domain.TipoCozinhaDomain;
import com.fiap.ms.restaurante.application.infraestrutura.TipoCozinha;
import com.fiap.ms.restaurante.infraestrutura.persistence.mapper.TipoCozinhaEntityMapper;
import com.fiap.ms.restaurante.infraestrutura.persistence.repositories.TipoCozinhaRepository;
import com.fiap.ms.restaurante.infraestrutura.persistence.specification.TipoCozinhaSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
    public Optional<TipoCozinhaDomain> buscarPorCodigo(Long codigo) {
        var entity = repository.findByCodigo(codigo);
        return entity.map(TipoCozinhaEntityMapper.INSTANCE::toTipoCozinhaDomain);
    }

    @Override
    public List<TipoCozinhaDomain> buscar(Long codigo, String descricao) {
        var spec = TipoCozinhaSpecification.filtrar(codigo, descricao);
        return repository.findAll(spec)
                .stream()
                .map(TipoCozinhaEntityMapper.INSTANCE::toTipoCozinhaDomain)
                .toList();
    }
}
