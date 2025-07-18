package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.implementations;

import com.fiap.ms.restaurante.domain.model.TipoCozinhaDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.TipoCozinhaEntity;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.repositories.TipoCozinhaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.fiap.ms.restaurante.mocks.TipoCozinhaMock.getTipoCozinhaDomain;
import static com.fiap.ms.restaurante.mocks.TipoCozinhaMock.getTipoCozinhaEntity;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
}
