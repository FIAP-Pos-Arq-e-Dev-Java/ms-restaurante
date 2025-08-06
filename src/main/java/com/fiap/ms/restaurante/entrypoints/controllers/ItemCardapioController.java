package com.fiap.ms.restaurante.entrypoints.controllers;

import com.fiap.ms.restaurante.application.usecase.itemCardapio.AtualizaItemCardapioUseCase;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.BuscaItemCardapioUseCase;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.DeletaItemCardapioUseCase;
import com.fiap.ms.restaurante.application.usecase.itemCardapio.InserirItemCardapioUseCase;
import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
import com.fiap.ms.restaurante.entrypoints.controllers.presenter.ItemCardapioPresenter;
import com.fiap.ms.restauranteDomain.ItemCardapioApi;
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
public class ItemCardapioController implements ItemCardapioApi{

    private final InserirItemCardapioUseCase inserirUseCase;
    private final BuscaItemCardapioUseCase buscaUseCase;
    private final DeletaItemCardapioUseCase deletaUseCase;
    private final AtualizaItemCardapioUseCase atualizaUseCase;

    public ItemCardapioController(InserirItemCardapioUseCase inserirItemCardapioUseCase,
                                  BuscaItemCardapioUseCase buscaItemCardapioUseCase,
                                  DeletaItemCardapioUseCase deletaItemCardapioUseCase,
                                  AtualizaItemCardapioUseCase atualizaItemCardapioUseCase) {
        this.inserirUseCase = inserirItemCardapioUseCase;
        this.buscaUseCase = buscaItemCardapioUseCase;
        this.deletaUseCase = deletaItemCardapioUseCase;
        this.atualizaUseCase = atualizaItemCardapioUseCase;
    }

    @Override
    public ResponseEntity<Void> _atualizarItemCardapio(Long id, ItemCardapioRequestDto itemCardapioRequestDto) {
        var domain = ItemCardapioPresenter.toItemCardapioDomain(itemCardapioRequestDto);
        atualizaUseCase.atualizar(id, domain);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<ItemCardapioDto>> _buscarItensCardapio(String nome, Boolean disponibilidadeConsumoLocal) {
        List<ItemCardapioDomain> itensCardapioDomain = buscaUseCase.buscar(nome, disponibilidadeConsumoLocal);
        List<ItemCardapioDto> dto = ItemCardapioPresenter.toListItemCardapioDto(itensCardapioDomain);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<Void> _deletarItemCardapio(Long id) {
        deletaUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> _inserirItemCardapio(ItemCardapioRequestDto itemCardapioRequestDto) {
        var domain = ItemCardapioPresenter.toItemCardapioDomain(itemCardapioRequestDto);
        inserirUseCase.inserir(domain);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
