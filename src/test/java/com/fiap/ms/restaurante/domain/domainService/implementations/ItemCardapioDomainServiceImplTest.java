//package com.fiap.ms.restaurante.domain.domainService.implementations;
//
//import com.fiap.ms.restaurante.application.gateways.ItemCardapio;
//import com.fiap.ms.restaurante.domain.exception.ObjetoJaExisteException;
//import com.fiap.ms.restaurante.domain.exception.ObjetoNaoExisteException;
//import com.fiap.ms.restaurante.domain.model.ItemCardapioDomain;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static com.fiap.ms.restaurante.mocks.ItemCardapioMock.getItemCardapioDomainCompleto;
//import static org.junit.Assert.assertThrows;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class ItemCardapioDomainServiceImplTest {
//
//    @InjectMocks
//    private ItemCardapioDomainServiceImpl itemCardapioDomainService;
//
//    @Mock
//    private ItemCardapio itemCardapio;
//
//    @Test
//    void checarExistenciaDescricao_descricaoExistente_objetoJaExisteException() {
//        ItemCardapioDomain itemCardapioDomain = getItemCardapioDomainCompleto();
//        when(itemCardapio.buscarPorDescricao(anyString())).thenReturn(Optional.of(itemCardapioDomain));
//
//        assertThrows(ObjetoJaExisteException.class, () -> itemCardapioDomainService.checarExistenciaDescricao("Pizza Margherita"));
//
//        verify(itemCardapio).buscarPorDescricao(anyString());
//    }
//
//    @Test
//    void checarExistenciaDescricao_descricaoNaoExistente_sucesso() {
//        when(itemCardapio.buscarPorDescricao(anyString())).thenReturn(Optional.empty());
//
//        itemCardapioDomainService.checarExistenciaDescricao("Pizza Margherita");
//
//        verify(itemCardapio).buscarPorDescricao(anyString());
//    }
//
//    @Test
//    void buscarTipoCozinhaPorCodigo_codigoExistente_ObjetoNaoExisteException() {
//        Long id = 1L;
//        when(itemCardapio.buscarPorId(any(Long.class))).thenReturn(Optional.empty());
//
//        assertThrows(ObjetoNaoExisteException.class, () -> itemCardapioDomainService.buscarItemCardapioPorId(id));
//
//        verify(itemCardapio).buscarPorId(any(Long.class));
//    }
//
//    @Test
//    void buscarTipoCozinhaPorCodigo_codigoNaoExistente_sucesso() {
//       Long id = 1L;
//        ItemCardapioDomain itemCardapioDomain = getItemCardapioDomainCompleto();
//
//        when(itemCardapio.buscarPorId(any(Long.class))).thenReturn(Optional.of(itemCardapioDomain));
//
//        itemCardapioDomainService.buscarItemCardapioPorId(id);
//
//        verify(itemCardapio).buscarPorId(any(Long.class));
//    }
//
//}
