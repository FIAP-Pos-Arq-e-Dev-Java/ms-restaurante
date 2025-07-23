package com.fiap.ms.restaurante.domain.model;

import java.util.UUID;

public class TipoCozinhaDomain {

    private UUID codigo;
    private String descricao;

    public TipoCozinhaDomain(){
    }

    public TipoCozinhaDomain(UUID codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
