package com.fiap.ms.restaurante.mocks;

import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.ItemCardapioEntity;

import java.math.BigDecimal;
import java.util.List;

public class ItemCardapioMock {

    public static ItemCardapioDomain getItemCardapioDomainCompleto() {
        ItemCardapioDomain itemCardapioDomain = new ItemCardapioDomain();
        itemCardapioDomain.setId(1L);
        itemCardapioDomain.setNome("Pizza Margherita");
        itemCardapioDomain.setDescricao("Pizza tradicional com molho de tomate, mussarela e manjericão.");
        itemCardapioDomain.setPreco(new BigDecimal("39.90"));
        itemCardapioDomain.setDisponibilidadeConsumoLocal(true);
        itemCardapioDomain.setFoto("/imagens/cardapio/pizza-margherita.jpg");
        return itemCardapioDomain;
    }

    public static ItemCardapioDomain getItemCardapioDomainSemNome() {
        return new ItemCardapioDomain(
                1L,
                " ",
                "Pizza tradicional com molho de tomate, mussarela e manjericão.",
                new BigDecimal("39.90"),
                true,
                "/imagens/cardapio/pizza-margherita.jpg"
        );
    }

    public static ItemCardapioDomain getItemCardapioDomainSemPreco() {
        return new ItemCardapioDomain(
                1L,
                "Pizza Margherita",
                "Pizza tradicional com molho de tomate, mussarela e manjericão.",
                new BigDecimal(" "),
                true,
                "/imagens/cardapio/pizza-margherita.jpg"
        );
    }


    public static List<ItemCardapioDomain> getItensCardapioDomain() {
        return List.of(
                new ItemCardapioDomain(
                        1L,
                        "Pizza Margherita",
                        "Pizza tradicional com molho de tomate, mussarela e manjericão.",
                        new BigDecimal("39.90"),
                        true,
                        "/imagens/cardapio/pizza-margherita.jpg"
                ),
                new ItemCardapioDomain(
                        2L,
                        "Hambúrguer Artesanal",
                        "Pão brioche, hambúrguer 180g, queijo cheddar, cebola caramelizada e bacon.",
                        new BigDecimal("29.50"),
                        true,
                        "/imagens/cardapio/hamburguer-artesanal.jpg"
                ),
                new ItemCardapioDomain(
                        3L,
                        "Salada Caesar",
                        "Alface romana, frango grelhado, parmesão e molho caesar.",
                        new BigDecimal("25.00"),
                        false,
                        "/imagens/cardapio/salada-caesar.jpg"
                )
        );
    }

    public static ItemCardapioEntity getItemCardapioEntity(){
        return new ItemCardapioEntity(1L,
                "Pizza Margherita",
                "Pizza tradicional com molho de tomate, mussarela e manjericão.",
                new BigDecimal("39.90"),
                true,
                "/imagens/cardapio/pizza-margherita.jpg");
    }
}
