package com.fiap.ms.restaurante.infraestrutura.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_tipo_cozinha")
public class TipoCozinhaEntity {

    @Id
    private Long codigo;
    private String descricao;
}
