package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.specification;

import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.ItemCardapioEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ItemCardapioSpecification {

    public static Specification<ItemCardapioEntity> filtrar(String nome, Boolean disponibilidadeConsumoLocal) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(nome != null) {
                predicates.add(cb.like(cb.lower(root.get("nome")), "%" + nome + "%"));
            }

            if(disponibilidadeConsumoLocal != null){
                predicates.add(cb.equal(root.get("disponibilidadeConsumoLocal"), disponibilidadeConsumoLocal));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
