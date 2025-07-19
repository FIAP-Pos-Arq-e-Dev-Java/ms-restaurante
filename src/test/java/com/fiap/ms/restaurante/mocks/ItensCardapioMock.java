package com.fiap.ms.restaurante.mocks;

import com.fiap.ms.restaurante.domain.model.ItensCardapioDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.ItensCardapioEntity;

import java.math.BigDecimal;
import java.util.List;

public class ItensCardapioMock {

    public static ItensCardapioDomain getItensCardapioDomainCompleto() {
        return new ItensCardapioDomain(
                1L,
                "Pizza Margherita",
                "Pizza tradicional com molho de tomate, mussarela e manjericão.",
                new BigDecimal("39.90"),
                "Disponível",
                "/imagens/cardapio/pizza-margherita.jpg"
        );
    }

    public static ItensCardapioDomain getItensCardapioDomainSemNome() {
        return new ItensCardapioDomain(
                1L,
                " ",
                "Pizza tradicional com molho de tomate, mussarela e manjericão.",
                new BigDecimal("39.90"),
                "Disponível",
                "/imagens/cardapio/pizza-margherita.jpg"
        );
    }

    public static ItensCardapioDomain getItensCardapioDomainSemPreco() {
        return new ItensCardapioDomain(
                1L,
                "Pizza Margherita",
                "Pizza tradicional com molho de tomate, mussarela e manjericão.",
                new BigDecimal(" "),
                "Disponível",
                "/imagens/cardapio/pizza-margherita.jpg"
        );
    }


    public static List<ItensCardapioDomain> getItensCardapioDomain() {
        return List.of(
                new ItensCardapioDomain(
                        1L,
                        "Pizza Margherita",
                        "Pizza tradicional com molho de tomate, mussarela e manjericão.",
                        new BigDecimal("39.90"),
                        "Disponível",
                        "/imagens/cardapio/pizza-margherita.jpg"
                ),
                new ItensCardapioDomain(
                        2L,
                        "Hambúrguer Artesanal",
                        "Pão brioche, hambúrguer 180g, queijo cheddar, cebola caramelizada e bacon.",
                        new BigDecimal("29.50"),
                        "Disponível",
                        "/imagens/cardapio/hamburguer-artesanal.jpg"
                ),
                new ItensCardapioDomain(
                        3L,
                        "Salada Caesar",
                        "Alface romana, frango grelhado, parmesão e molho caesar.",
                        new BigDecimal("25.00"),
                        "Indisponível",
                        "/imagens/cardapio/salada-caesar.jpg"
                )
        );
    }

    public static ItensCardapioEntity getItensCardapioEntity(){
        return new ItensCardapioEntity(1L,
                "Pizza Margherita",
                "Pizza tradicional com molho de tomate, mussarela e manjericão.",
                new BigDecimal("39.90"),
                "Disponível",
                "/imagens/cardapio/pizza-margherita.jpg");
    }
}
