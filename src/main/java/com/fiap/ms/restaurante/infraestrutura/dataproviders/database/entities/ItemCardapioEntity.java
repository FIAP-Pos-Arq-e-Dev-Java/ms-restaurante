package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_item_cardapio")
public class ItemCardapioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    @Column(name = "disponibilidade_consumo_local")
    private Boolean disponibilidadeConsumoLocal;

    private String foto;
}
