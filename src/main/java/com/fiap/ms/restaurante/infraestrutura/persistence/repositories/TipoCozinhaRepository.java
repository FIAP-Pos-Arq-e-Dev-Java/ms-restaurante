package com.fiap.ms.restaurante.infraestrutura.persistence.repositories;

import com.fiap.ms.restaurante.infraestrutura.persistence.entities.TipoCozinhaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface TipoCozinhaRepository extends JpaRepository<TipoCozinhaEntity, Long>, JpaSpecificationExecutor<TipoCozinhaEntity> {

//    Optional<TipoCozinhaEntity> findByDescricaoIgnoreCase(String descricao);
//
//    List<TipoCozinhaEntity> findByTipoCozinha();

    Optional<TipoCozinhaEntity> findByCodigo(Long codigo);
}
