package com.fiap.ms.restaurante.domain.rules;

import com.fiap.ms.restaurante.domain.exception.CampoObrigatorioException;
import org.junit.jupiter.api.Test;

import static com.fiap.ms.restaurante.domain.rules.ValidarDescricaoObrigatoriaRule.validarDescricaoObrigatoria;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ValidarDescricaoObrigatoriaRuleTest {

    @Test
    void deveLancarCampoObrigatorioException_quandoDescricaoForNull() {
        assertThrows(CampoObrigatorioException.class, () -> validarDescricaoObrigatoria(null));
    }

    @Test
    void deveLancarCampoObrigatorioException_quandoDescricaoForVazia() {
        String descricao = "";

        assertThrows(CampoObrigatorioException.class, () -> validarDescricaoObrigatoria(descricao));
    }

    @Test
    void deveLancarCampoObrigatorioException_quandoDescricaoForEspacosEmBranco() {
        String descricao = "   ";

        assertThrows(CampoObrigatorioException.class, () -> validarDescricaoObrigatoria(descricao));
    }

    @Test
    void deveValidarDescricaoObrigatoriaSemExcecao_quandoDescricaoForValida() {
        String descricao = "Prato do Dia";

        assertDoesNotThrow(() -> validarDescricaoObrigatoria(descricao));
    }

    @Test
    void testeCoberturaController() {
        ValidarDescricaoObrigatoriaRule validator = new ValidarDescricaoObrigatoriaRule();

        assertNotNull(validator);
    }
}
