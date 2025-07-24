package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.repositories;

import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.RestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface RestauranteRepository extends JpaRepository<RestauranteEntity, UUID>, JpaSpecificationExecutor<RestauranteEntity> {

}
