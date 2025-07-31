package com.fiap.ms.restaurante.mocks;

import com.fiap.ms.restaurante.domain.model.EnderecoDomain;
import com.fiap.ms.restaurante.domain.model.RestauranteDomain;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.EnderecoEntity;
import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.RestauranteEntity;
import com.fiap.ms.restauranteDomain.gen.model.EnderecoDto;
import com.fiap.ms.restauranteDomain.gen.model.RestauranteRequestDto;

import java.util.List;

public class RestauranteMock {

    public static RestauranteRequestDto getRestauranteRequestDto() {
        RestauranteRequestDto restauranteRequestDto = new RestauranteRequestDto();
        restauranteRequestDto.setNome("Churrascaria do Zé");
        restauranteRequestDto.setHorarioFuncionamento("11:00 - 22:00");
        restauranteRequestDto.setTipoCozinha("BRASILEIRA");
        restauranteRequestDto.setEndereco(getEnderecoDto());
        return restauranteRequestDto;
    }

    public static List<RestauranteDomain> getListRestauranteDomain() {
        return List.of(getRestauranteDomain());
    }

    public static RestauranteDomain getRestauranteDomain() {
        RestauranteDomain restauranteDomain = new RestauranteDomain();
        restauranteDomain.setId(1L);
        restauranteDomain.setUsuarioId(1L);
        restauranteDomain.setNome("Churrascaria do Zé");
        restauranteDomain.setHorarioFuncionamento("11:00 - 22:00");
        restauranteDomain.setTipoCozinha("BRASILEIRA");
        restauranteDomain.setEndereco(getEnderecoDomain());
        return restauranteDomain;
    }

    public static List<RestauranteEntity> getListRestauranteEntity() {
        return List.of(getRestauranteEntity());
    }

    public static RestauranteEntity getRestauranteEntity() {
        RestauranteEntity restauranteEntity = new RestauranteEntity();
        restauranteEntity.setId(1L);
        restauranteEntity.setUsuarioId(1L);
        restauranteEntity.setNome("Churrascaria do Zé");
        restauranteEntity.setHorarioFuncionamento("11:00 - 22:00");
        restauranteEntity.setTipoCozinha("BRASILEIRA");
        restauranteEntity.setEndereco(getEnderecoEntity());
        return restauranteEntity;
    }

    private static EnderecoDto getEnderecoDto() {
        EnderecoDto enderecoDto = new EnderecoDto();
        enderecoDto.setCity("Campinas");
        enderecoDto.setComplement("Sala 5");
        enderecoDto.setNumber("123");
        enderecoDto.setStreet("Rua das Acácias");
        enderecoDto.setState("SP");
        return enderecoDto;
    }

    private static EnderecoDomain getEnderecoDomain() {
        EnderecoDomain enderecoDomain = new EnderecoDomain();
        enderecoDomain.setCity("Campinas");
        enderecoDomain.setComplement("Sala 5");
        enderecoDomain.setNumber("123");
        enderecoDomain.setStreet("Rua das Acácias");
        enderecoDomain.setState("SP");
        return enderecoDomain;
    }

    private static EnderecoEntity getEnderecoEntity() {
        EnderecoEntity enderecoEntity = new EnderecoEntity();
        enderecoEntity.setCity("Campinas");
        enderecoEntity.setComplement("Sala 5");
        enderecoEntity.setNumber("123");
        enderecoEntity.setStreet("Rua das Acácias");
        enderecoEntity.setState("SP");
        return enderecoEntity;
    }
}
