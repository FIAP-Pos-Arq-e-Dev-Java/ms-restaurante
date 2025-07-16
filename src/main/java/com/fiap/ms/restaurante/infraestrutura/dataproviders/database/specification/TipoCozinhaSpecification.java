package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.specification;

import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.TipoCozinhaEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class TipoCozinhaSpecification {

    public static Specification<TipoCozinhaEntity> filtrar(Long codigo, String descricao) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (codigo != null) {
                predicates.add(cb.equal(root.get("id"), codigo));
            }

            if (descricao != null && !descricao.trim().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("descricao")), "%" + descricao.toLowerCase() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
