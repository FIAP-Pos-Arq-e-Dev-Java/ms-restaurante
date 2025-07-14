package com.fiap.ms.restaurante.infraestrutura.api.controllers;

import com.fiap.ms.restauranteDomain.RestauranteApi;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteDto;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1")
public class RestauranteController  implements RestauranteApi {

    @Override
    public ResponseEntity<RestauranteDto> _atualizarRestaurante(Integer id, RestauranteRequestDto restauranteRequestDto) {
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<RestauranteDto> _buscarRestaurantePorUsuario(Integer usuario) {
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> _criarRestaurante(RestauranteRequestDto restauranteRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> _deletarRestaurante(String id) {
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<RestauranteDto>> _listarRestaurantes() {
        return ResponseEntity.ok().build();
    }
}
