package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.specification;

import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.ItemCardapioEntity;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.domain.Specification;

import static org.junit.jupiter.api.Assertions.*;

class ItemCardapioSpecificationTest {

    @Test
    void testFiltrar_WithAllParameters_ShouldCreateSpecification() {
        // Arrange
        String nome = "Pizza Margherita";
        Boolean disponibilidadeConsumoLocal = true;

        // Act
        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(nome, disponibilidadeConsumoLocal);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithOnlyNome_ShouldCreateSpecification() {
        // Arrange
        String nome = "Pizza Margherita";

        // Act
        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(nome, null);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithOnlyDisponibilidadeTrue_ShouldCreateSpecification() {
        // Arrange
        Boolean disponibilidadeConsumoLocal = true;

        // Act
        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(null, disponibilidadeConsumoLocal);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithOnlyDisponibilidadeFalse_ShouldCreateSpecification() {
        // Arrange
        Boolean disponibilidadeConsumoLocal = false;

        // Act
        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(null, disponibilidadeConsumoLocal);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithNomeAndDisponibilidadeTrue_ShouldCreateSpecification() {
        // Arrange
        String nome = "Hambúrguer";
        Boolean disponibilidadeConsumoLocal = true;

        // Act
        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(nome, disponibilidadeConsumoLocal);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithNomeAndDisponibilidadeFalse_ShouldCreateSpecification() {
        // Arrange
        String nome = "Salada Caesar";
        Boolean disponibilidadeConsumoLocal = false;

        // Act
        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(nome, disponibilidadeConsumoLocal);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithAllNullParameters_ShouldCreateSpecification() {
        // Act
        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(null, null);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithEmptyNome_ShouldCreateSpecification() {
        // Arrange
        String nome = "";
        Boolean disponibilidadeConsumoLocal = true;

        // Act
        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(nome, disponibilidadeConsumoLocal);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithNomeWithSpaces_ShouldCreateSpecification() {
        // Arrange
        String nome = "  Pizza Quattro Stagioni  ";
        Boolean disponibilidadeConsumoLocal = false;

        // Act
        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(nome, disponibilidadeConsumoLocal);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithSpecialCharactersInNome_ShouldCreateSpecification() {
        // Arrange
        String nome = "Açaí & Granola";
        Boolean disponibilidadeConsumoLocal = true;

        // Act
        Specification<ItemCardapioEntity> specification = ItemCardapioSpecification.filtrar(nome, disponibilidadeConsumoLocal);

        // Assert
        assertNotNull(specification);
    }
}
