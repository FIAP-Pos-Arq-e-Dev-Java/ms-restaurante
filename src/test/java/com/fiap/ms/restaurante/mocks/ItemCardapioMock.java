package com.fiap.ms.restaurante.mocks;

import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.ItemCardapioEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ItemCardapioMock {

    public static ItemCardapioDomain getItemCardapioDomainCompleto() {
        ItemCardapioDomain itemCardapioDomain = new ItemCardapioDomain();
        itemCardapioDomain.setId(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"));
        itemCardapioDomain.setNome("Pizza Margherita");
        itemCardapioDomain.setDescricao("Pizza tradicional com molho de tomate, mussarela e manjericão.");
        itemCardapioDomain.setPreco(new BigDecimal("39.90"));
        itemCardapioDomain.setDisponibilidadeConsumoLocal(true);
        itemCardapioDomain.setFoto("/imagens/cardapio/pizza-margherita.jpg");
        return itemCardapioDomain;
    }

    public static ItemCardapioDomain getItemCardapioDomainSemNome() {
        return new ItemCardapioDomain(
                UUID.fromString("550e8400-e29b-41d4-a716-446655440000"),
                " ",
                "Pizza tradicional com molho de tomate, mussarela e manjericão.",
                new BigDecimal("39.90"),
                true,
                "/imagens/cardapio/pizza-margherita.jpg"
        );
    }

    public static ItemCardapioDomain getItemCardapioDomainSemPreco() {
        return new ItemCardapioDomain(
                UUID.fromString("550e8400-e29b-41d4-a716-446655440000"),
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
                        UUID.fromString("550e8400-e29b-41d4-a716-446655440000"),
                        "Pizza Margherita",
                        "Pizza tradicional com molho de tomate, mussarela e manjericão.",
                        new BigDecimal("39.90"),
                        true,
                        "/imagens/cardapio/pizza-margherita.jpg"
                ),
                new ItemCardapioDomain(
                        UUID.fromString("11111111-1111-1111-1111-111111111111"),
                        "Hambúrguer Artesanal",
                        "Pão brioche, hambúrguer 180g, queijo cheddar, cebola caramelizada e bacon.",
                        new BigDecimal("29.50"),
                        true,
                        "/imagens/cardapio/hamburguer-artesanal.jpg"
                ),
                new ItemCardapioDomain(
                        UUID.fromString("22222222-2222-2222-2222-222222222222"),
                        "Salada Caesar",
                        "Alface romana, frango grelhado, parmesão e molho caesar.",
                        new BigDecimal("25.00"),
                        false,
                        "/imagens/cardapio/salada-caesar.jpg"
                )
        );
    }

    public static ItemCardapioEntity getItemCardapioEntity(){
        return new ItemCardapioEntity(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"),
                "Pizza Margherita",
                "Pizza tradicional com molho de tomate, mussarela e manjericão.",
                new BigDecimal("39.90"),
                true,
                "/imagens/cardapio/pizza-margherita.jpg");
    }
}
