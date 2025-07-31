package com.fiap.ms.restaurante.application.usecase.restaurante;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.application.usecase.restaurante.implementations.BuscaRestauranteUsuarioIdUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BuscaRestauranteUsuarioIdUseCaseImplTest {

    @InjectMocks
    private BuscaRestauranteUsuarioIdUseCaseImpl buscaRestauranteUsuarioIdUseCase;

    @Mock
    private Restaurante restaurante;

    @Test
    void buscarUsuarioPorId_usuarioNaoEncontrado() {
        Long usuarioId = 2L;
        when(restaurante.buscarUsuarioPorId(usuarioId)).thenReturn(false);

        Boolean usuarioExiste = buscaRestauranteUsuarioIdUseCase.buscarUsuarioPorId(usuarioId);

        assertEquals(false, usuarioExiste);
        verify(restaurante, times(1)).buscarUsuarioPorId(usuarioId);
    }

    @Test
    void buscarUsuarioPorId_usuarioEncontrado() {
        Long usuarioId = 1L;
        when(restaurante.buscarUsuarioPorId(usuarioId)).thenReturn(true);

        Boolean usuarioExiste = buscaRestauranteUsuarioIdUseCase.buscarUsuarioPorId(usuarioId);

        assertEquals(true, usuarioExiste);
        verify(restaurante, times(1)).buscarUsuarioPorId(usuarioId);
    }
}
