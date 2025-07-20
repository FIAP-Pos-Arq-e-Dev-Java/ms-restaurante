package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.implementations;

import com.fiap.ms.restaurante.domain.model.ItensCardapioDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.ItensCardapioEntity;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.repositories.ItensCardapioRepository;
import com.fiap.ms.restaurante.mocks.ItensCardapioMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ItensCardapioImplTest {

    @InjectMocks
    private ItensCardapioImpl itensCardapioImpl;

    @Mock
    private ItensCardapioRepository repository;

    @Test
    void salvarItemCardapioSucesso() {
        ItensCardapioEntity item = ItensCardapioMock.getItensCardapioEntity();
        repository.save(item);
        verify(repository, times(1)).save(item);
    }

    @Test
    void encontraItemCardapioComId() {
        ItensCardapioDomain item = ItensCardapioMock.getItensCardapioDomainCompleto();
        ItensCardapioEntity entity = ItensCardapioMock.getItensCardapioEntity();
        when(repository.findById(entity.getId())).thenReturn(Optional.of(entity));

        itensCardapioImpl.findById(item.getId());

        assertNotNull(item);
        verify(repository, times(1)).findById(item.getId());
    }

    @Test
    void buscarTodosItensCardapio() {
        List<ItensCardapioEntity> entities = List.of(ItensCardapioMock.getItensCardapioEntity());
        when(repository.findAll(any(Specification.class))).thenReturn(entities);

        itensCardapioImpl.buscarTodos(null, null);

        verify(repository, times(1)).findAll(any(Specification.class));
    }

    @Test
    void deletar() {
        ItensCardapioDomain itens =  ItensCardapioMock.getItensCardapioDomainCompleto();
        ItensCardapioEntity entity = ItensCardapioMock.getItensCardapioEntity();
        doNothing().when(repository).delete(entity);

        itensCardapioImpl.deletar(itens);

        verify(repository, times(1)).delete(entity);
    }
}