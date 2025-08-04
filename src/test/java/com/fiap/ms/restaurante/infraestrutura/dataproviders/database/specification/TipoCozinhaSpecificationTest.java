package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.specification;

import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.TipoCozinhaEntity;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.domain.Specification;

import static org.junit.jupiter.api.Assertions.*;

class TipoCozinhaSpecificationTest {

    @Test
    void testFiltrar_WithAllParameters_ShouldCreateSpecification() {
        Long codigo = 1L;
        String descricao = "Italiana";

        Specification<TipoCozinhaEntity> specification = TipoCozinhaSpecification.filtrar(codigo, descricao);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithOnlyCodigo_ShouldCreateSpecification() {
        Long codigo = 1L;

        Specification<TipoCozinhaEntity> specification = TipoCozinhaSpecification.filtrar(codigo, null);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithOnlyDescricao_ShouldCreateSpecification() {
        String descricao = "Italiana";

        Specification<TipoCozinhaEntity> specification = TipoCozinhaSpecification.filtrar(null, descricao);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithEmptyDescricao_ShouldCreateSpecification() {
        Long codigo = 1L;
        String descricao = "";

        Specification<TipoCozinhaEntity> specification = TipoCozinhaSpecification.filtrar(codigo, descricao);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithWhitespaceDescricao_ShouldCreateSpecification() {
        Long codigo = 1L;
        String descricao = "   ";

        Specification<TipoCozinhaEntity> specification = TipoCozinhaSpecification.filtrar(codigo, descricao);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithDescricaoWithSpaces_ShouldCreateSpecification() {
        String descricao = "  Italiana  ";

        Specification<TipoCozinhaEntity> specification = TipoCozinhaSpecification.filtrar(null, descricao);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithAllNullParameters_ShouldCreateSpecification() {
        Specification<TipoCozinhaEntity> specification = TipoCozinhaSpecification.filtrar(null, null);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithZeroCodigo_ShouldCreateSpecification() {
        Long codigo = 0L;
        String descricao = "Brasileira";

        Specification<TipoCozinhaEntity> specification = TipoCozinhaSpecification.filtrar(codigo, descricao);

        assertNotNull(specification);
    }

    @Test
    void testFiltrar_WithNegativeCodigo_ShouldCreateSpecification() {
        Long codigo = -1L;
        String descricao = "Japonesa";

        Specification<TipoCozinhaEntity> specification = TipoCozinhaSpecification.filtrar(codigo, descricao);

        assertNotNull(specification);
    }
}
