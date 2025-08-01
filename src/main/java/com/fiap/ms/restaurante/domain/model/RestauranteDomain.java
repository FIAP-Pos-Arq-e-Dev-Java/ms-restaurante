package com.fiap.ms.restaurante.domain.model;

import java.util.List;

public class RestauranteDomain {

    private Long id;
    private String nome;
    private EnderecoDomain endereco;
    private Long tipoCozinhaId;
    private String horarioFuncionamento;
    private Long usuarioId;
    private List<ItemCardapioDomain> itemCardapio;

    public RestauranteDomain(){
    }

    public RestauranteDomain(Long id, String nome, EnderecoDomain endereco, Long tipoCozinhaId, String horarioFuncionamento, Long usuarioId) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.tipoCozinhaId = tipoCozinhaId;
        this.horarioFuncionamento = horarioFuncionamento;
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnderecoDomain getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDomain endereco) {
        this.endereco = endereco;
    }

    public Long getTipoCozinhaId() {
        return tipoCozinhaId;
    }

    public void setTipoCozinhaId(Long tipoCozinhaId) {
        this.tipoCozinhaId = tipoCozinhaId;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<ItemCardapioDomain> getItemCardapio() {
        return itemCardapio;
    }

    public void setItemCardapio(List<ItemCardapioDomain> itemCardapio) {
        this.itemCardapio = itemCardapio;
    }
}
