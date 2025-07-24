package com.fiap.ms.restaurante.domain.domainService;

import com.fiap.ms.restaurante.domain.model.RestauranteDomain;

import java.util.UUID;

public interface RestauranteDomainService {

    RestauranteDomain buscaRestaurantePorId(UUID id);
}
