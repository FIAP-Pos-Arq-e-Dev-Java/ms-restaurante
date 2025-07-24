package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity(name = "tb_tipo_cozinha")
public class TipoCozinhaEntity {

    @Id
    private Long codigo;

    private String descricao;
}
