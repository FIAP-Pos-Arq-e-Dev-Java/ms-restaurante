package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.repositories;

import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.ItensCardapioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;


public interface ItensCardapioRepository extends JpaRepository<ItensCardapioEntity, Long>, JpaSpecificationExecutor<ItensCardapioEntity> {

    Optional<ItensCardapioEntity> findByNome(String nome);
}
