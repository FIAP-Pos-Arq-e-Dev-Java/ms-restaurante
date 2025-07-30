package com.fiap.ms.restaurante.entrypoints.controllers;

import com.fiap.ms.restaurante.application.usecase.address.CreateAddressUseCase;
import com.fiap.ms.restaurante.application.usecase.address.DeleteAddressUseCase;
import com.fiap.ms.restaurante.application.usecase.address.FindAddressUseCase;
import com.fiap.ms.restaurante.application.usecase.address.UpdateAddressUseCase;
import com.fiap.ms.restaurante.domain.model.AddressDomain;
import com.fiap.ms.restaurante.entrypoints.controllers.mappers.AddressDtoMapper;
import com.fiap.ms.restauranteDomain.EnderecoApi;
import com.fiap.ms.restauranteDomain.gen.model.EnderecoDto;
import com.fiap.ms.restauranteDomain.gen.model.EnderecoRequestDto;
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
public class EnderecoController implements EnderecoApi {

    private final CreateAddressUseCase createAddressUseCase;
    private final DeleteAddressUseCase deleteAddressUseCase;
    private final UpdateAddressUseCase updateAddressUseCase;
    private final FindAddressUseCase findAddressUseCase;

    public EnderecoController(CreateAddressUseCase createAddressUseCase,
                              DeleteAddressUseCase deleteAddressUseCase,
                              UpdateAddressUseCase updateAddressUseCase,
                              FindAddressUseCase findAddressUseCase) {
        this.createAddressUseCase = createAddressUseCase;
        this.deleteAddressUseCase = deleteAddressUseCase;
        this.updateAddressUseCase = updateAddressUseCase;
        this.findAddressUseCase = findAddressUseCase;
    }

    @Override
    public ResponseEntity<Void> _atualizarEndereco(Long id, EnderecoRequestDto enderecoRequestDto) {
        var domain = AddressDtoMapper.INSTANCE.toAddressDomain(enderecoRequestDto);
        updateAddressUseCase.update(id, domain);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<EnderecoDto>> _buscarEnderecos(String cidade, String estado) {
        List<AddressDomain> domain = findAddressUseCase.findAddress(cidade, estado);
        List<EnderecoDto> dto = domain.stream().map(AddressDtoMapper.INSTANCE::toAddressDto).collect(Collectors.toList());
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<Void> _deletarEndereco(Long id) {
        deleteAddressUseCase.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> _inserirEndereco(EnderecoRequestDto enderecoRequestDto) {
        var domain = AddressDtoMapper.INSTANCE.toAddressDomain(enderecoRequestDto);
        createAddressUseCase.createAddress(domain);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
