package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_item_cardapio")
public class ItemCardapioEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    @Column(name = "disponibilidade_consumo_local")
    private Boolean disponibilidadeConsumoLocal;

    private String foto;
}
