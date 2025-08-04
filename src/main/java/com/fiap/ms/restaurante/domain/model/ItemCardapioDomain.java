package com.fiap.ms.restaurante.domain.model;

import java.math.BigDecimal;

public class ItemCardapioDomain {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean disponibilidadeConsumoLocal;
    private String foto;
    private Long restauranteId;

    public ItemCardapioDomain() {
    }

    public ItemCardapioDomain(Long id, String nome, String descricao, BigDecimal preco, Boolean disponibilidadeConsumoLocal, String foto, Long restauranteId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.disponibilidadeConsumoLocal = disponibilidadeConsumoLocal;
        this.foto = foto;
        this.restauranteId = restauranteId;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Boolean getDisponibilidadeConsumoLocal() {
        return disponibilidadeConsumoLocal;
    }

    public void setDisponibilidadeConsumoLocal(Boolean disponibilidadeConsumoLocal) {
        this.disponibilidadeConsumoLocal = disponibilidadeConsumoLocal;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Long getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(Long restauranteId) {
        this.restauranteId = restauranteId;
    }
}
