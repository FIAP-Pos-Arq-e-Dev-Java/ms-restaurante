package com.fiap.ms.restaurante.mocks;

import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.ItemCardapioEntity;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.RestauranteEntity;
import com.fiap.ms.restauranteDomain.gen.model.ItemCardapioRequestDto;

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
        itemCardapioDomain.setRestauranteId(1L);
        return itemCardapioDomain;
    }

    public static ItemCardapioDomain getItemCardapioDomainSemNome() {
        return new ItemCardapioDomain(
                1L,
                " ",
                "Pizza tradicional com molho de tomate, mussarela e manjericão.",
                new BigDecimal("39.90"),
                true,
                "/imagens/cardapio/pizza-margherita.jpg",
                1L
        );
    }

    public static ItemCardapioDomain getItemCardapioDomainSemPreco() {
        return new ItemCardapioDomain(
                1L,
                "Pizza Margherita",
                "Pizza tradicional com molho de tomate, mussarela e manjericão.",
                new BigDecimal(" "),
                true,
                "/imagens/cardapio/pizza-margherita.jpg",
                1L
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
                        "/imagens/cardapio/pizza-margherita.jpg",
                        1L
                ),
                new ItemCardapioDomain(
                        1L,
                        "Hambúrguer Artesanal",
                        "Pão brioche, hambúrguer 180g, queijo cheddar, cebola caramelizada e bacon.",
                        new BigDecimal("29.50"),
                        true,
                        "/imagens/cardapio/hamburguer-artesanal.jpg",
                        1L
                ),
                new ItemCardapioDomain(
                        1L,
                        "Salada Caesar",
                        "Alface romana, frango grelhado, parmesão e molho caesar.",
                        new BigDecimal("25.00"),
                        false,
                        "/imagens/cardapio/salada-caesar.jpg",
                        1L
                )
        );
    }

    public static ItemCardapioEntity getItemCardapioEntity(){
        return new ItemCardapioEntity(1L,
                "Pizza Margherita",
                "Pizza tradicional com molho de tomate, mussarela e manjericão.",
                new BigDecimal("39.90"),
                true,
                "/imagens/cardapio/pizza-margherita.jpg",
                1L);
    }

    public static ItemCardapioRequestDto getItemCardapioRequestDto(){
        ItemCardapioRequestDto itemCardapioRequestDto = new ItemCardapioRequestDto();
        itemCardapioRequestDto.setNome("Pizza Margherita");
        itemCardapioRequestDto.setDescricao("Pizza tradicional com molho de tomate, mussarela e manjericão.");
        itemCardapioRequestDto.setFoto("/imagens/cardapio/pizza-margherita.jpg");
        itemCardapioRequestDto.setDisponibilidadeConsumoLocal(true);
        itemCardapioRequestDto.setPreco(39.90);
        return itemCardapioRequestDto;
    }
}

