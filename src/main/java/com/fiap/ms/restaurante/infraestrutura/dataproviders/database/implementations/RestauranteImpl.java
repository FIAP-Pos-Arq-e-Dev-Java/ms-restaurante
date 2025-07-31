package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.implementations;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.mapper.RestauranteEntityMapper;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.repositories.RestauranteRepository;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.specification.RestauranteSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RestauranteImpl implements Restaurante {

    private final RestauranteRepository repository;

    @Override
    public void deletar(RestauranteDomain restauranteDomain) {
        var entity = RestauranteEntityMapper.INSTANCE.toRestauranteEntity(restauranteDomain);
        repository.delete(entity);
    }

    @Override
    public void salvar(RestauranteDomain restauranteDomain) {
        var entity = RestauranteEntityMapper.INSTANCE.toRestauranteEntity(restauranteDomain);
        repository.save(entity);
    }

    @Override
    public Optional<RestauranteDomain> buscarPorId(Long id) {
        var entity = repository.findById(id);
        return entity.map(RestauranteEntityMapper.INSTANCE::toRestauranteDomain);
    }

    @Override
    public List<RestauranteDomain> buscar(String nome, Long usuarioId, String horarioFuncionamento) {
        var spec = RestauranteSpecification.filtrar(nome, usuarioId, horarioFuncionamento);
        return repository.findAll(spec)
                .stream()
                .map(RestauranteEntityMapper.INSTANCE::toRestauranteDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean buscarUsuarioPorId(Long usuarioId) {
        return repository.existsByUsuarioId(usuarioId);
    }
}
