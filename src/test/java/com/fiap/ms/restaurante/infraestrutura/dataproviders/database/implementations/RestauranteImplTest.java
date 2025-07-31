package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.implementations;

import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.RestauranteEntity;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.repositories.RestauranteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

import static com.fiap.ms.restaurante.mocks.RestauranteMock.getListRestauranteEntity;
import static com.fiap.ms.restaurante.mocks.RestauranteMock.getRestauranteDomain;
import static com.fiap.ms.restaurante.mocks.RestauranteMock.getRestauranteEntity;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RestauranteImplTest {

    @InjectMocks
    private RestauranteImpl restaurante;

    @Mock
    private RestauranteRepository repository;

    @Test
    void deletarTipoCozinha_sucesso() {
        RestauranteDomain restauranteDomain = getRestauranteDomain();
        RestauranteEntity restauranteEntity = getRestauranteEntity();

        doNothing().when(repository).delete(restauranteEntity);

        restaurante.deletar(restauranteDomain);

        verify(repository, times(1)).delete(restauranteEntity);
    }

    @Test
    void inserir_atualizarTipoCozinha_sucesso() {
        RestauranteDomain restauranteDomain = getRestauranteDomain();
        RestauranteEntity restauranteEntity = getRestauranteEntity();

        when(repository.save(restauranteEntity)).thenReturn(restauranteEntity);

        restaurante.salvar(restauranteDomain);

        verify(repository, times(1)).save(restauranteEntity);
    }

    @Test
    void buscarRestaurantePorId_sucesso() {
        RestauranteDomain restauranteDomain = getRestauranteDomain();
        RestauranteEntity restauranteEntity = getRestauranteEntity();

        when(repository.findById(restauranteEntity.getId())).thenReturn(Optional.of(restauranteEntity));

        Optional<RestauranteDomain> result = restaurante.buscarPorId(restauranteDomain.getId());

        assertNotNull(result);
        verify(repository, times(1)).findById(restauranteDomain.getId());
    }

    @Test
    void buscarRestaurante_semFiltro_sucesso() {
        List<RestauranteEntity> entities = getListRestauranteEntity();
        when(repository.findAll(any(Specification.class))).thenReturn(entities);

        restaurante.buscar(null,null, null);

        verify(repository, times(1)).findAll(any(Specification.class));
    }

    @Test
    void buscarUsuarioPorId_usuarioNaoEncontrado() {
        Long usuarioId = 2L;
        when(repository.existsByUsuarioId(usuarioId)).thenReturn(false);

        Boolean usuarioExiste = restaurante.buscarUsuarioPorId(usuarioId);

        assertEquals(false, usuarioExiste);
        verify(repository, times(1)).existsByUsuarioId(usuarioId);
    }

    @Test
    void buscarUsuarioPorId_usuarioEncontrado() {
        Long usuarioId = 1L;
        when(repository.existsByUsuarioId(usuarioId)).thenReturn(true);

        Boolean usuarioExiste = restaurante.buscarUsuarioPorId(usuarioId);

        assertEquals(true, usuarioExiste);
        verify(repository, times(1)).existsByUsuarioId(usuarioId);
    }
}
