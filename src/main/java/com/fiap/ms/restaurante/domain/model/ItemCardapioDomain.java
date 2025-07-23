package com.fiap.ms.restaurante.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemCardapioDomain {

    private UUID id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean disponibilidadeConsumoLocal;
    private String foto;

    public ItemCardapioDomain(UUID id , String nome, String descricao, BigDecimal preco, Boolean disponibilidadeConsumoLocal, String foto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.disponibilidadeConsumoLocal = disponibilidadeConsumoLocal;
        this.foto = foto;
    }

    public ItemCardapioDomain() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
}
