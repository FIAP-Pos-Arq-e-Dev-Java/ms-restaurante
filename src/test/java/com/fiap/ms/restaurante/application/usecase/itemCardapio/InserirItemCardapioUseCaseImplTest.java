//package com.fiap.ms.restaurante.application.usecase.itemCardapio;
//
//import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
//import com.fiap.ms.restaurante.application.usecase.itemCardapio.implementations.InserirItemCardapioUseCaseImpl;
//import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
//import com.fiap.ms.restaurante.mocks.ItemCardapioMock;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class InserirItemCardapioUseCaseImplTest {
//
//    @InjectMocks
//    private InserirItemCardapioUseCaseImpl inserirItemCardapioUseCase;
//
//    @Mock
//    private ItemCardapio itemCardapio;
//
//    @Test
//    void deveSalvarItemCardapio(){
//        //Arrange
//        ItemCardapioDomain item = ItemCardapioMock.getItensCardapioDomainCompleto();
//
//        //Act
//        itemCardapio.salvar(item);
//
//        //Assert
//        verify(itemCardapio, times(1)).salvar(item);
//    }
//}
