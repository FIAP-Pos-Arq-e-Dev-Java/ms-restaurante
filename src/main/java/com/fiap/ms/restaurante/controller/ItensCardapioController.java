package com.fiap.ms.restaurante.controller;

import com.fiap.ms.restauranteDomain.ItensCardapioApi;
import com.fiap.ms.restauranteDomain.gen.model.ItemCardapioDto;
import com.fiap.ms.restauranteDomain.gen.model.ItemCardapioRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1")
public class ItensCardapioController implements ItensCardapioApi {

    @Override
    public ResponseEntity<ItemCardapioDto> _atualizarItemCardapio(Integer usuario, Integer idItem, ItemCardapioRequestDto itemCardapioRequestDto) {
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ItemCardapioDto> _buscarItemCardapioPorId(Integer usuario, Integer idItem) {
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> _criarItemCardapio(Integer usuario, ItemCardapioDto itemCardapioDto) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> _deletarItemCardapio(Integer usuario, Integer idItem) {
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ItemCardapioDto> _listaItensCardapioPorID(Integer id) {
        return ResponseEntity.ok().body(new ItemCardapioDto());
    }

    @Override
    public ResponseEntity<List<ItemCardapioDto>> _listarItensCardapio(Integer usuario) {
        return ResponseEntity.ok().build();
    }
}
