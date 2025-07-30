package com.fiap.ms.restaurante.infraestrutura.dataproviders.database.specification;

import com.fiap.ms.restaurante.infraestrutura.dataproviders.database.entities.AddressEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AddressSpecification {

    public static Specification<AddressEntity> filter(String city, String state){
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(city != null){
                predicates.add(cb.like(cb.lower(root.get("city")), "%" + city + "%"));
            }

            if(state != null){
                predicates.add(cb.like(cb.lower(root.get("state")), "%" + state + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
