package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.specification;

import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.RestauranteEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate;

public class RestauranteSpecification {

    public static Specification<RestauranteEntity> filtrar(String nome, String endereco, String horarioFuncionamento){
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(nome != null){
                predicates.add(cb.like(cb.lower(root.get("nome")), "%" + nome + "%"));
            }

            if(endereco != null){
                predicates.add(cb.like(cb.lower(root.get("endereco")), "%" + endereco + "%"));
            }

            if(horarioFuncionamento != null){
                predicates.add(cb.equal(root.get("horarioFuncionamento"), horarioFuncionamento));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
