package com.fiap.ms.restaurante.entrypoints.controllers;

import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import com.fiap.ms.restaurante.application.usecase.tipoCozinha.AtualizarTipoCozinhaUseCase;
import com.fiap.ms.restaurante.application.usecase.tipoCozinha.BuscarTipoCozinhaUseCase;
import com.fiap.ms.restaurante.application.usecase.tipoCozinha.DeletarTipoCozinhaUseCase;
import com.fiap.ms.restaurante.application.usecase.tipoCozinha.InserirTipoCozinhaUseCase;
import com.fiap.ms.restaurante.entrypoints.controllers.mappers.TipoCozinhaDtoMapper;
import com.fiap.ms.restauranteDomain.TipoCozinhaApi;
import com.fiap.ms.restauranteDomain.gen.model.TipoCozinhaDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1")
public class TipoCozinhaController implements TipoCozinhaApi {

    private final InserirTipoCozinhaUseCase inserirTipoCozinhaUseCase;
    private final DeletarTipoCozinhaUseCase deletarTipoCozinhaUseCase;
    private final AtualizarTipoCozinhaUseCase atualizarTipoCozinhaUseCase;
    private final BuscarTipoCozinhaUseCase buscarTipoCozinhaUseCase;

    public TipoCozinhaController(InserirTipoCozinhaUseCase inserirTipoCozinhaUseCase,
                                 DeletarTipoCozinhaUseCase deletarTipoCozinhaUseCase,
                                 AtualizarTipoCozinhaUseCase atualizarTipoCozinhaUseCase,
                                 BuscarTipoCozinhaUseCase buscarTipoCozinhaUseCase) {
        this.inserirTipoCozinhaUseCase = inserirTipoCozinhaUseCase;
        this.deletarTipoCozinhaUseCase = deletarTipoCozinhaUseCase;
        this.atualizarTipoCozinhaUseCase = atualizarTipoCozinhaUseCase;
        this.buscarTipoCozinhaUseCase = buscarTipoCozinhaUseCase;
    }

    @Override
    public ResponseEntity<Void> _atualizarTipoCozinha(Long codigo, TipoCozinhaDto tipoCozinhaDto) {
        var domain = TipoCozinhaDtoMapper.INSTANCE.toDomain(tipoCozinhaDto);
        atualizarTipoCozinhaUseCase.atualizar(codigo, domain);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<TipoCozinhaDto>> _buscarTiposCozinhas(Long codigo, String descricao) {
        List<TipoCozinhaDomain> dominios = buscarTipoCozinhaUseCase.buscar(codigo, descricao);
        List<TipoCozinhaDto> dtos = dominios.stream()
                .map(TipoCozinhaDtoMapper.INSTANCE::toTipoCozinhaDto)
                .toList();

        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<Void> _deletarTipoCozinha(Long codigo) {
        deletarTipoCozinhaUseCase.deletar(codigo);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<TipoCozinhaDto> _inserirTipoCozinha(TipoCozinhaDto tipoCozinhaDto) {
        var domain = TipoCozinhaDtoMapper.INSTANCE.toDomain(tipoCozinhaDto);
        inserirTipoCozinhaUseCase.inserir(domain);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
