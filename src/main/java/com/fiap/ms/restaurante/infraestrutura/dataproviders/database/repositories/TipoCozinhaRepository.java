package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.repositories;

import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.TipoCozinhaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

public interface TipoCozinhaRepository extends JpaRepository<TipoCozinhaEntity, Long>, JpaSpecificationExecutor<TipoCozinhaEntity> {

    Optional<TipoCozinhaEntity> findByCodigo(UUID codigo);

    Optional<TipoCozinhaEntity> findByDescricaoIgnoreCase(String descricao);
}
