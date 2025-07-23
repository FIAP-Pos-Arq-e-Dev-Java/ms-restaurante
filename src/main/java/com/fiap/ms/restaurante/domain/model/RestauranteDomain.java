package com.fiap.ms.restaurante.domain.model;

import java.util.UUID;

public class RestauranteDomain {

    private UUID id;
    private String nome;
    private String endereco;
    private String horarioFuncionamento;

    //Mudar para um atributo para armazenar o microservice de usuario
//    private UsuarioDomain usuario;


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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }
}
