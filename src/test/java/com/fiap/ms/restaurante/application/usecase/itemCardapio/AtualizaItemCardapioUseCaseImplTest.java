//package com.fiap.ms.restaurante.application.usecase.itemCardapio;
//
//import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
//import com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations.AtualizaItemCardapioUseCaseImpl;
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
//
//@ExtendWith(MockitoExtension.class)
//public class AtualizaItemCardapioUseCaseImplTest {
//
//    @InjectMocks
//    private AtualizaItemCardapioUseCaseImpl atualizaItemCardapioUseCase;
//
//    @Mock
//    private ItemCardapio itemCardapio;
//
//    @Test
//    void atualizaItemCardapio() {
//        // Arrange
//        ItemCardapioDomain item = ItensCardapioMock.getItensCardapioDomainCompleto();
//        when(itemCardapio.buscarPorId(item.getId())).thenReturn(Optional.of(item));
//        doNothing().when(itemCardapio).salvar(item);
//
//        // Act
//        atualizaItemCardapioUseCase.atualiza(item.getId(), item);
//
//        // Assert
//        verify(itemCardapio, times(1)).buscarPorId(item.getId());
//        verify(itemCardapio, times(1)).salvar(item);
//    }
//
//    @Test
//    void atualizaItemCardapioNaoEncontrado() {
//
//    }
//}
