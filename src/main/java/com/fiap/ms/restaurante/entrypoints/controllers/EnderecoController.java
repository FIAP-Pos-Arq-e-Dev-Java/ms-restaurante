package com.fiap.ms.restaurante.entrypoints.controllers;

import com.fiap.ms.restauranteDomain.EnderecoApi;
import com.fiap.ms.restauranteDomain.gen.model.EnderecoDto;
import com.fiap.ms.restauranteDomain.gen.model.EnderecoRequestDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class EnderecoController implements EnderecoApi {

    @Override
    public ResponseEntity<Void> _atualizarEndereco(Long id, EnderecoRequestDto enderecoRequestDto) {
        return null;
    }

    @Override
    public ResponseEntity<List<EnderecoDto>> _buscarEnderecos(String cidade, String estado) {
        return null;
    }

    @Override
    public ResponseEntity<Void> _deletarEndereco(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> _inserirEndereco(EnderecoRequestDto enderecoRequestDto) {
        return null;
    }
}
