//package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.implementations;
//
//import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
//import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.ItemCardapioEntity;
//import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.repositories.ItemCardapioRepository;
//import com.fiap.ms.restaurante.mocks.ItemCardapioMock;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.data.jpa.domain.Specification;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class ItemCardapioImplTest {
//
//    @InjectMocks
//    private ItemCardapioImpl itensCardapioImpl;
//
//    @Mock
//    private ItemCardapioRepository repository;
//
//    @Test
//    void salvarItemCardapioSucesso() {
//        ItemCardapioEntity item = ItemCardapioMock.getItensCardapioEntity();
//        repository.save(item);
//        verify(repository, times(1)).save(item);
//    }
//
//    @Test
//    void encontraItemCardapioComId() {
//        ItemCardapioDomain item = ItemCardapioMock.getItensCardapioDomainCompleto();
//        ItemCardapioEntity entity = ItemCardapioMock.getItensCardapioEntity();
//        when(repository.findById(entity.getId())).thenReturn(Optional.of(entity));
//
//        itensCardapioImpl.buscarPorId(item.getId());
//
//        assertNotNull(item);
//        verify(repository, times(1)).findById(item.getId());
//    }
//
//    @Test
//    void buscarTodosItensCardapio() {
//        List<ItemCardapioEntity> entities = List.of(ItemCardapioMock.getItensCardapioEntity());
//        when(repository.findAll(any(Specification.class))).thenReturn(entities);
//
//        itensCardapioImpl.buscarTodos(null, null);
//
//        verify(repository, times(1)).findAll(any(Specification.class));
//    }
//
//    @Test
//    void deletar() {
//        ItemCardapioDomain itens =  ItemCardapioMock.getItensCardapioDomainCompleto();
//        ItemCardapioEntity entity = ItemCardapioMock.getItensCardapioEntity();
//        doNothing().when(repository).delete(entity);
//
//        itensCardapioImpl.deletar(itens);
//
//        verify(repository, times(1)).delete(entity);
//    }
//}