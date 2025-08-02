package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.specification;

import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.TipoCozinhaEntity;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.domain.Specification;

import static org.junit.jupiter.api.Assertions.*;

class TipoCozinhaSpecificationTest {

    @Test
    void testFiltrar_WithAllParameters_ShouldCreateSpecification() {
        // Arrange
        Long codigo = 1L;
        String descricao = "Italiana";

        // Act
        Specification<TipoCozinhaEntity> specification = TipoCozinhaSpecification.filtrar(codigo, descricao);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithOnlyCodigo_ShouldCreateSpecification() {
        // Arrange
        Long codigo = 1L;

        // Act
        Specification<TipoCozinhaEntity> specification = TipoCozinhaSpecification.filtrar(codigo, null);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithOnlyDescricao_ShouldCreateSpecification() {
        // Arrange
        String descricao = "Italiana";

        // Act
        Specification<TipoCozinhaEntity> specification = TipoCozinhaSpecification.filtrar(null, descricao);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithEmptyDescricao_ShouldCreateSpecification() {
        // Arrange
        Long codigo = 1L;
        String descricao = "";

        // Act
        Specification<TipoCozinhaEntity> specification = TipoCozinhaSpecification.filtrar(codigo, descricao);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithWhitespaceDescricao_ShouldCreateSpecification() {
        // Arrange
        Long codigo = 1L;
        String descricao = "   ";

        // Act
        Specification<TipoCozinhaEntity> specification = TipoCozinhaSpecification.filtrar(codigo, descricao);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithDescricaoWithSpaces_ShouldCreateSpecification() {
        // Arrange
        String descricao = "  Italiana  ";

        // Act
        Specification<TipoCozinhaEntity> specification = TipoCozinhaSpecification.filtrar(null, descricao);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithAllNullParameters_ShouldCreateSpecification() {
        // Act
        Specification<TipoCozinhaEntity> specification = TipoCozinhaSpecification.filtrar(null, null);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithZeroCodigo_ShouldCreateSpecification() {
        // Arrange
        Long codigo = 0L;
        String descricao = "Brasileira";

        // Act
        Specification<TipoCozinhaEntity> specification = TipoCozinhaSpecification.filtrar(codigo, descricao);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithNegativeCodigo_ShouldCreateSpecification() {
        // Arrange
        Long codigo = -1L;
        String descricao = "Japonesa";

        // Act
        Specification<TipoCozinhaEntity> specification = TipoCozinhaSpecification.filtrar(codigo, descricao);

        // Assert
        assertNotNull(specification);
    }
}
