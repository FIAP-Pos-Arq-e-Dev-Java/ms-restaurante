package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities;

import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_cozinha_id")
    private TipoCozinhaEntity tipoCozinha;

    private String horarioFuncionamento;

    @Column(name = "usuario_id")
    private Long usuarioId;

    @OneToMany(mappedBy = "restauranteId", fetch = FetchType.LAZY)
    List<ItemCardapioEntity> itemCardapio;
}