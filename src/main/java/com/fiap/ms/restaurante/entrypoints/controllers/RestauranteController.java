package com.fiap.ms.restaurante.entrypoints.controllers;

import com.fiap.ms.restaurante.application.usecase.restaurante.*;
import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import com.fiap.ms.restaurante.entrypoints.controllers.mappers.RestauranteDtoMapper;
import com.fiap.ms.restauranteDomain.RestauranteApi;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteDto;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteRequestDto;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteUserExistsResponseDto;
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
    private final BuscaRestauranteUsuarioIdUseCase buscaRestauranteUsuarioIdUseCase;

    public RestauranteController(InserirRestauranteUseCase inserirRestauranteUseCase,
                                 BuscarRestauranteUseCase buscarRestauranteUseCase,
                                 DeletarRestauranteUseCase deletarRestauranteUseCase,
                                 AtualizarRestauranteUseCase atualizarRestauranteUseCase,
                                 BuscaRestauranteUsuarioIdUseCase buscaRestauranteUsuarioIdUseCase) {
        this.inserirRestauranteUseCase = inserirRestauranteUseCase;
        this.buscarRestauranteUseCase = buscarRestauranteUseCase;
        this.deletarRestauranteUseCase = deletarRestauranteUseCase;
        this.atualizarRestauranteUseCase = atualizarRestauranteUseCase;
        this.buscaRestauranteUsuarioIdUseCase = buscaRestauranteUsuarioIdUseCase;
    }

    @Override
    public ResponseEntity<RestauranteDto> _atualizarRestaurante(Long id, RestauranteRequestDto restauranteRequestDto) {
        var domain = RestauranteDtoMapper.INSTANCE.toRestauranteDomain(restauranteRequestDto);
        atualizarRestauranteUseCase.atualizar(id, domain);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<RestauranteDto>> _buscarRestaurante(String nome, Long usuarioId, String horarioFuncionamento) {
        List<RestauranteDomain> domain = buscarRestauranteUseCase.buscar(nome, usuarioId, horarioFuncionamento);
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
        var domain = RestauranteDtoMapper.INSTANCE.toRestauranteDomain(restauranteRequestDto);
        inserirRestauranteUseCase.inserir(domain);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<RestauranteUserExistsResponseDto> _verificarExistenciaUsuarioRestaurante(Long usuarioId) {
        boolean exists = buscaRestauranteUsuarioIdUseCase.findRestaurantByIdUser(usuarioId);
        return ResponseEntity.ok(new RestauranteUserExistsResponseDto().exists(exists));
    }
}