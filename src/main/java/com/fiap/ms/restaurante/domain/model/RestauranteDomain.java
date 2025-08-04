package com.fiap.ms.restaurante.domain.model;

import java.util.List;

public class RestauranteDomain {

    private Long id;
    private String nome;
    private EnderecoDomain endereco;
    private TipoCozinhaDomain tipoCozinha;
    private String horarioFuncionamento;
    private Long usuarioId;
    private List<ItemCardapioDomain> itemCardapio;

    public RestauranteDomain(){
    }

    public RestauranteDomain(Long id, String nome, EnderecoDomain endereco, TipoCozinhaDomain tipoCozinha, String horarioFuncionamento, Long usuarioId, List<ItemCardapioDomain> itemCardapio) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.tipoCozinha = tipoCozinha;
        this.horarioFuncionamento = horarioFuncionamento;
        this.usuarioId = usuarioId;
        this.itemCardapio = itemCardapio;
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

    public TipoCozinhaDomain getTipoCozinha() {
        return tipoCozinha;
    }

    public void setTipoCozinha(TipoCozinhaDomain tipoCozinha) {
        this.tipoCozinha = tipoCozinha;
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
