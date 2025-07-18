package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.specification;

import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.ItensCardapioEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ItensCardapioSpecification {

    public static Specification<ItensCardapioEntity> filtrar(String nome, Boolean disponivelSomenteNoRestaurante) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(nome != null) {
                predicates.add(cb.like(cb.lower(root.get("nome")), "%" + nome + "%"));
            }

            if(disponivelSomenteNoRestaurante != null){
                predicates.add(cb.equal(root.get("disponibilidade"), disponivelSomenteNoRestaurante));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
