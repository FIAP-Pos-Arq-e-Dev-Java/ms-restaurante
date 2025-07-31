package com.fiap.ms.restaurante.application.usecase.restaurante;

import com.fiap.ms.restaurante.application.gateways.Restaurante;
import com.fiap.ms.restaurante.application.usecase.restaurante.implementations.InserirRestauranteUseCaseImpl;
import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static com.fiap.ms.restaurante.mocks.RestauranteMock.getRestauranteDomain;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InserirRestauranteUseCaseImplTest {

    @InjectMocks
    private InserirRestauranteUseCaseImpl inserirRestauranteUseCase;

    @Mock
    private Restaurante restaurante;

    @Test
    void inserirRestaurante_sucesso(){
        RestauranteDomain restauranteDomain = getRestauranteDomain();

        doNothing().when(restaurante).salvar(restauranteDomain);

        try (MockedStatic<SecurityContextHolder> mockedStatic = mockStatic(SecurityContextHolder.class)) {
            Authentication mockAuth = mock(Authentication.class);
            SecurityContext mockSecurityContext = mock(SecurityContext.class);

            when(mockAuth.getPrincipal()).thenReturn("1");
            when(mockSecurityContext.getAuthentication()).thenReturn(mockAuth);
            mockedStatic.when(SecurityContextHolder::getContext).thenReturn(mockSecurityContext);

            inserirRestauranteUseCase.inserir(restauranteDomain);

            verify(restaurante, times(1)).salvar(restauranteDomain);
        }
    }
}
