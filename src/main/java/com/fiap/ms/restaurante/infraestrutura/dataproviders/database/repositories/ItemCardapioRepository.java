package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.repositories;

import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.ItemCardapioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapioEntity, Long>, JpaSpecificationExecutor<ItemCardapioEntity> {

    Optional<ItemCardapioEntity> findByDescricaoIgnoreCase(String descricao);
}
