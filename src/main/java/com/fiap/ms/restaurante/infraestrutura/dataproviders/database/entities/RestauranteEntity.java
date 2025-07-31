package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_restaurante")
public class RestauranteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Embedded
    private EnderecoEntity endereco;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "tipo_cozinha_id")
    //TODO MUDAR PARA LONG E FAZER O RELACIONAMENTO
    //private TipoCozinhaEntity tipoCozinha;
    private String tipoCozinha;

    private String horarioFuncionamento;

//    @Column(name = "usuario_id")
    private Long usuarioId;

    //TODO MUDAR ATE O SWAGGER E VOLTAR UM LIST
    // CRIAR DOMAIN E DTO
    // SE NECESSARIO AJUSTAR OS MAPPERS
    //private List<ItemCardapioEntity> itemCardapios;
}