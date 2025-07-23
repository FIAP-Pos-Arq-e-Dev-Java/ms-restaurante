package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.implementations;

import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.TipoCozinhaEntity;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.repositories.TipoCozinhaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

import static com.fiap.ms.restaurante.mocks.TipoCozinhaMock.getListTipoCozinhaEntity;
import static com.fiap.ms.restaurante.mocks.TipoCozinhaMock.getTipoCozinhaDomain;
import static com.fiap.ms.restaurante.mocks.TipoCozinhaMock.getTipoCozinhaEntity;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TipoCozinhaImplTest {

    @InjectMocks
    private TipoCozinhaImpl tipoCozinha;

    @Mock
    private TipoCozinhaRepository tipoCozinhaRepository;

    @Test
    void deletarTipoCozinha_sucesso() {
        TipoCozinhaDomain tipoCozinhaDomain = getTipoCozinhaDomain();
        TipoCozinhaEntity tipoCozinhaEntity = getTipoCozinhaEntity();

        doNothing().when(tipoCozinhaRepository).delete(tipoCozinhaEntity);

        tipoCozinha.deletar(tipoCozinhaDomain);

        verify(tipoCozinhaRepository, times(1)).delete(tipoCozinhaEntity);
    }

    @Test
    void inserir_atualizarTipoCozinha_sucesso() {
        TipoCozinhaDomain tipoCozinhaDomain = getTipoCozinhaDomain();
        TipoCozinhaEntity tipoCozinhaEntity = getTipoCozinhaEntity();

        when(tipoCozinhaRepository.save(tipoCozinhaEntity)).thenReturn(tipoCozinhaEntity);

        tipoCozinha.salvar(tipoCozinhaDomain);

        verify(tipoCozinhaRepository, times(1)).save(tipoCozinhaEntity);
    }

    @Test
    void buscarTipoCozinhaPorCodigo_sucesso() {
        TipoCozinhaDomain tipoCozinhaDomain = getTipoCozinhaDomain();
        TipoCozinhaEntity tipoCozinhaEntity = getTipoCozinhaEntity();

        when(tipoCozinhaRepository.findByCodigo(tipoCozinhaEntity.getCodigo())).thenReturn(Optional.of(tipoCozinhaEntity));

        Optional<TipoCozinhaDomain> result = tipoCozinha.buscarPorCodigo(tipoCozinhaDomain.getCodigo());

        assertNotNull(result);
        verify(tipoCozinhaRepository, times(1)).findByCodigo(tipoCozinhaEntity.getCodigo());
    }

    @Test
    void buscarTipoCozinhaPorDescricao_sucesso() {
        TipoCozinhaDomain tipoCozinhaDomain = getTipoCozinhaDomain();
        TipoCozinhaEntity tipoCozinhaEntity = getTipoCozinhaEntity();

        when(tipoCozinhaRepository.findByDescricaoIgnoreCase(tipoCozinhaEntity.getDescricao())).thenReturn(Optional.of(tipoCozinhaEntity));

        Optional<TipoCozinhaDomain> result = tipoCozinha.buscarPorDescricao(tipoCozinhaDomain.getDescricao());

        assertNotNull(result);
        verify(tipoCozinhaRepository, times(1)).findByDescricaoIgnoreCase(tipoCozinhaEntity.getDescricao());
    }

    @Test
    void buscarTipoCozinha_sucesso() {
        List<TipoCozinhaEntity> entities = getListTipoCozinhaEntity();
        when(tipoCozinhaRepository.findAll(any(Specification.class))).thenReturn(entities);

        tipoCozinha.buscar(null, null);

        verify(tipoCozinhaRepository, times(1)).findAll(any(Specification.class));
    }
}
