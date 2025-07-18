package com.fiap.ms.restaurante.domain.model;

import java.math.BigDecimal;

public class ItensCardapioDomain {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private String disponibilidade;
    private String foto;

    public ItensCardapioDomain(String nome, String descricao, BigDecimal preco, String disponibilidade, String foto) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.disponibilidade = disponibilidade;
        this.foto = foto;
    }

    public ItensCardapioDomain() {
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

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
