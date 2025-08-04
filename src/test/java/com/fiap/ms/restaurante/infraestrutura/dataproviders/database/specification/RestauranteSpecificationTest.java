package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.specification;

import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.RestauranteEntity;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.domain.Specification;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class RestauranteSpecificationTest {

    @Test
    void testFiltrar_WithAllParameters_ShouldCreateSpecification() {
        String nome = "Test Restaurant";
        Long usuarioId = 123L;
        String horarioFuncionamento = "08:00-22:00";

        Specification<RestauranteEntity> specification = RestauranteSpecification.filtrar(nome, usuarioId, horarioFuncionamento);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithOnlyNome_ShouldCreateSpecification() {
        String nome = "Test Restaurant";

        Specification<RestauranteEntity> specification = RestauranteSpecification.filtrar(nome, null, null);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithOnlyUsuarioId_ShouldCreateSpecification() {
        Long usuarioId = 123L;

        Specification<RestauranteEntity> specification = RestauranteSpecification.filtrar(null, usuarioId, null);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithOnlyHorarioFuncionamento_ShouldCreateSpecification() {
        String horarioFuncionamento = "08:00-22:00";

        Specification<RestauranteEntity> specification = RestauranteSpecification.filtrar(null, null, horarioFuncionamento);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithNomeAndUsuarioId_ShouldCreateSpecification() {
        String nome = "Test Restaurant";
        Long usuarioId = 123L;

        Specification<RestauranteEntity> specification = RestauranteSpecification.filtrar(nome, usuarioId, null);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithNomeAndHorarioFuncionamento_ShouldCreateSpecification() {
        String nome = "Test Restaurant";
        String horarioFuncionamento = "08:00-22:00";

        Specification<RestauranteEntity> specification = RestauranteSpecification.filtrar(nome, null, horarioFuncionamento);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithUsuarioIdAndHorarioFuncionamento_ShouldCreateSpecification() {
        Long usuarioId = 123L;
        String horarioFuncionamento = "08:00-22:00";

        Specification<RestauranteEntity> specification = RestauranteSpecification.filtrar(null, usuarioId, horarioFuncionamento);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithAllNullParameters_ShouldCreateSpecification() {
        Specification<RestauranteEntity> specification = RestauranteSpecification.filtrar(null, null, null);

        assertNotNull(specification);
    }
}