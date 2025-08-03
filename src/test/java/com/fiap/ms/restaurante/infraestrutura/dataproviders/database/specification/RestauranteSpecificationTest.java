package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.specification;

import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.RestauranteEntity;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.domain.Specification;

import static org.junit.jupiter.api.Assertions.*;

class RestauranteSpecificationTest {

    @Test
    void testFiltrar_WithAllParameters_ShouldCreateSpecification() {
        // Arrange
        String nome = "Test Restaurant";
        Long usuarioId = 123L;
        String horarioFuncionamento = "08:00-22:00";

        // Act
        Specification<RestauranteEntity> specification = RestauranteSpecification.filtrar(nome, usuarioId, horarioFuncionamento);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithOnlyNome_ShouldCreateSpecification() {
        // Arrange
        String nome = "Test Restaurant";

        // Act
        Specification<RestauranteEntity> specification = RestauranteSpecification.filtrar(nome, null, null);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithOnlyUsuarioId_ShouldCreateSpecification() {
        // Arrange
        Long usuarioId = 123L;

        // Act
        Specification<RestauranteEntity> specification = RestauranteSpecification.filtrar(null, usuarioId, null);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithOnlyHorarioFuncionamento_ShouldCreateSpecification() {
        // Arrange
        String horarioFuncionamento = "08:00-22:00";

        // Act
        Specification<RestauranteEntity> specification = RestauranteSpecification.filtrar(null, null, horarioFuncionamento);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithNomeAndUsuarioId_ShouldCreateSpecification() {
        // Arrange
        String nome = "Test Restaurant";
        Long usuarioId = 123L;

        // Act
        Specification<RestauranteEntity> specification = RestauranteSpecification.filtrar(nome, usuarioId, null);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithNomeAndHorarioFuncionamento_ShouldCreateSpecification() {
        // Arrange
        String nome = "Test Restaurant";
        String horarioFuncionamento = "08:00-22:00";

        // Act
        Specification<RestauranteEntity> specification = RestauranteSpecification.filtrar(nome, null, horarioFuncionamento);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithUsuarioIdAndHorarioFuncionamento_ShouldCreateSpecification() {
        // Arrange
        Long usuarioId = 123L;
        String horarioFuncionamento = "08:00-22:00";

        // Act
        Specification<RestauranteEntity> specification = RestauranteSpecification.filtrar(null, usuarioId, horarioFuncionamento);

        // Assert
        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithAllNullParameters_ShouldCreateSpecification() {
        // Act
        Specification<RestauranteEntity> specification = RestauranteSpecification.filtrar(null, null, null);

        // Assert
        assertNotNull(specification);
    }
}