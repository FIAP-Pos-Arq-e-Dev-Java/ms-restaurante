package com.fiap.ms.restaurante.entrypoints.controllers;

import com.fiap.ms.restaurante.application.usecase.restaurante.AtualizarRestauranteUseCase;
import com.fiap.ms.restaurante.application.usecase.restaurante.BuscarRestauranteUseCase;
import com.fiap.ms.restaurante.application.usecase.restaurante.DeletarRestauranteUseCase;
import com.fiap.ms.restaurante.application.usecase.restaurante.InserirRestauranteUseCase;
import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import com.fiap.ms.restaurante.entrypoints.controllers.mappers.RestauranteDtoMapper;
import com.fiap.ms.restauranteDomain.RestauranteApi;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteDto;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/v1")
public class RestauranteController implements RestauranteApi{

    private final InserirRestauranteUseCase inserirRestauranteUseCase;
    private final BuscarRestauranteUseCase buscarRestauranteUseCase;
    private final DeletarRestauranteUseCase deletarRestauranteUseCase;
    private final AtualizarRestauranteUseCase atualizarRestauranteUseCase;

    public RestauranteController(InserirRestauranteUseCase inserirRestauranteUseCase,
                                 BuscarRestauranteUseCase buscarRestauranteUseCase,
                                 DeletarRestauranteUseCase deletarRestauranteUseCase,
                                 AtualizarRestauranteUseCase atualizarRestauranteUseCase) {
        this.inserirRestauranteUseCase = inserirRestauranteUseCase;
        this.buscarRestauranteUseCase = buscarRestauranteUseCase;
        this.deletarRestauranteUseCase = deletarRestauranteUseCase;
        this.atualizarRestauranteUseCase = atualizarRestauranteUseCase;
    }

    @Override
    public ResponseEntity<RestauranteDto> _atualizarRestaurante(Long id, RestauranteRequestDto restauranteRequestDto) {
        var domain = RestauranteDtoMapper.INSTANCE.toDomain(restauranteRequestDto);
        atualizarRestauranteUseCase.atualizar(id, domain);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<RestauranteDto>> _buscarRestaurante(String nome, String endereco, String horarioFuncionamento) {
        List<RestauranteDomain> domain = buscarRestauranteUseCase.buscar(nome, endereco, horarioFuncionamento);
        List<RestauranteDto> dtos = domain.stream().map(RestauranteDtoMapper.INSTANCE::toRestauranteDto).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<Void> _deletarRestaurante(Long id) {
        deletarRestauranteUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> _inserirRestaurante(RestauranteRequestDto restauranteRequestDto) {
        var domain = RestauranteDtoMapper.INSTANCE.toDomain(restauranteRequestDto);
        inserirRestauranteUseCase.inserir(domain);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}