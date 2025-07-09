package com.fiap.ms.restaurante.controller;

import com.fiap.ms.restauranteDomain.RestauranteApi;
import com.fiap.ms.restauranteDomain.gen.model.AtualizarUsuarioRequestDto;
import com.fiap.ms.restauranteDomain.gen.model.UsuarioDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1")
public class RestauranteController implements RestauranteApi {

    @Override
    public ResponseEntity<UsuarioDto> _atualizarRestaurante(String usuario, AtualizarUsuarioRequestDto atualizarUsuarioRequestDto) {
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UsuarioDto> _buscarRestaurante(String usuario) {
        return ResponseEntity.ok(new UsuarioDto());
    }

    @Override
    public ResponseEntity<Void> _deletarRestaurante(String usuario) {
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> _inserirRestaurante(UsuarioDto usuarioDto) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
