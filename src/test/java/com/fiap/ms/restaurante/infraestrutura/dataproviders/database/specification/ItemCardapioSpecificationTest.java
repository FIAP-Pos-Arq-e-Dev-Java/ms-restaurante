package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.specification;

import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.ItemCardapioEntity;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.domain.Specification;

import static org.junit.jupiter.api.Assertions.*;

class ItemCardapioSpecificationTest {

    @Test
    void testFiltrar_WithAllParameters_ShouldCreateSpecification() {
        String nome = "Pizza Margherita";
        Boolean disponibilidadeConsumoLocal = true;

        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(nome, disponibilidadeConsumoLocal);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithOnlyNome_ShouldCreateSpecification() {
        String nome = "Pizza Margherita";

        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(nome, null);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithOnlyDisponibilidadeTrue_ShouldCreateSpecification() {
        Boolean disponibilidadeConsumoLocal = true;

        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(null, disponibilidadeConsumoLocal);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithOnlyDisponibilidadeFalse_ShouldCreateSpecification() {
        Boolean disponibilidadeConsumoLocal = false;

        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(null, disponibilidadeConsumoLocal);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithNomeAndDisponibilidadeTrue_ShouldCreateSpecification() {
        String nome = "Hambúrguer";
        Boolean disponibilidadeConsumoLocal = true;

        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(nome, disponibilidadeConsumoLocal);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithNomeAndDisponibilidadeFalse_ShouldCreateSpecification() {
        String nome = "Salada Caesar";
        Boolean disponibilidadeConsumoLocal = false;

        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(nome, disponibilidadeConsumoLocal);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithAllNullParameters_ShouldCreateSpecification() {
        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(null, null);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithEmptyNome_ShouldCreateSpecification() {
        String nome = "";
        Boolean disponibilidadeConsumoLocal = true;

        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(nome, disponibilidadeConsumoLocal);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithNomeWithSpaces_ShouldCreateSpecification() {
        String nome = "  Pizza Quattro Stagioni  ";
        Boolean disponibilidadeConsumoLocal = false;

        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(nome, disponibilidadeConsumoLocal);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithSpecialCharactersInNome_ShouldCreateSpecification() {
        String nome = "Açaí & Granola";
        Boolean disponibilidadeConsumoLocal = true;

        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(nome, disponibilidadeConsumoLocal);

        assertNotNull(specification);
    }
}
