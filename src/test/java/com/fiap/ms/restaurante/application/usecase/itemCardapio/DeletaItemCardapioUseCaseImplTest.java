//package com.fiap.ms.restaurante.application.usecase.itemCardapio;
//
//import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
//import com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations.DeletaItemCardapioUseCaseImpl;
//import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
//import com.fiap.ms.restaurante.mocks.ItensCardapioMock;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(MockitoExtension.class)
//public class DeletaItemCardapioUseCaseImplTest {
//
//    @InjectMocks
//    private DeletaItemCardapioUseCaseImpl itensCardapioUseCaseImpl;
//
//    @Mock
//    private ItemCardapio itemCardapio;
//
//    @Test
//    void deletaItemCardapio(){
//        // Arrange
//        ItemCardapioDomain item = ItensCardapioMock.getItensCardapioDomainCompleto();
//        when(itemCardapio.buscarPorId(1L)).thenReturn(Optional.of(item));
//        doNothing().when(itemCardapio).deletar(item);
//
//        // Act
//        itensCardapioUseCaseImpl.deletar(1L);
//
//        // Assert
//        verify(itemCardapio, times(1)).buscarPorId(1L);
//        verify(itemCardapio, times(1)).deletar(item);
//    }
//
//    @Test
//    void deveLancarExcecaoQuandoItemNaoExiste() {
//        // Arrange
//        Long id = 1L;
//        when(itemCardapio.buscarPorId(id)).thenReturn(Optional.empty());
//
//        // Act & Assert
//        RuntimeException exception = assertThrows(RuntimeException.class,
//                () -> itensCardapioUseCaseImpl.deletar(id));
//
//        assertEquals("Item cardápio inexistente", exception.getMessage());
//
//        verify(itemCardapio, times(1)).buscarPorId(id);
//        verify(itemCardapio, never()).deletar(any());
//    }
//}
