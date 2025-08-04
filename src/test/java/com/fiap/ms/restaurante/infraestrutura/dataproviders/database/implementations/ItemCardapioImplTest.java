//package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.implementations;
//
//import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
//import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.ItemCardapioEntity;
//import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.repositories.ItemCardapioRepository;
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
//import static com.fiap.ms.restaurante.mocks.ItemCardapioMock.getItemCardapioDomainCompleto;
//import static com.fiap.ms.restaurante.mocks.ItemCardapioMock.getItemCardapioEntity;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
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
//        ItemCardapioDomain itemCardapioDomain = getItemCardapioDomainCompleto();
//        ItemCardapioEntity item = getItemCardapioEntity();
//
//        when(repository.save(item)).thenReturn(item);
//
//        itensCardapioImpl.salvar(itemCardapioDomain);
//        verify(repository, times(1)).save(item);
//    }
//
//    @Test
//    void encontraItemCardapioComId() {
//        ItemCardapioDomain item = getItemCardapioDomainCompleto();
//        ItemCardapioEntity entity = getItemCardapioEntity();
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
//        List<ItemCardapioEntity> entities = List.of(getItemCardapioEntity());
//        when(repository.findAll(any(Specification.class))).thenReturn(entities);
//
//        itensCardapioImpl.buscarTodos(null, null);
//
//        verify(repository, times(1)).findAll(any(Specification.class));
//    }
//
//    @Test
//    void deletarItemCardapio_sucesso() {
//        ItemCardapioDomain itens =  getItemCardapioDomainCompleto();
//        ItemCardapioEntity entity = getItemCardapioEntity();
//        doNothing().when(repository).delete(entity);
//
//        itensCardapioImpl.deletar(itens);
//
//        verify(repository, times(1)).delete(entity);
//    }
//
//    @Test
//    void buscarItemCardapioPorDescricao_sucesso() {
//        ItemCardapioDomain itens =  getItemCardapioDomainCompleto();
//        ItemCardapioEntity entity = getItemCardapioEntity();
//
//        when(repository.findByDescricaoIgnoreCase(entity.getDescricao())).thenReturn(Optional.of(entity));
//
//        Optional<ItemCardapioDomain> result = itensCardapioImpl.buscarPorDescricao(itens.getDescricao());
//
//        assertNotNull(result);
//        verify(repository, times(1)).findByDescricaoIgnoreCase(entity.getDescricao());
//    }
//}