package io.github.henrik13.usedcarmarket.specification;

import io.github.henrik13.usedcarmarket.model.Car;
import jakarta.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

import java.util.Locale;

@Slf4j
public class CarSpecifications {

    public static Specification<Car> getCarsByFilter(CarFilter filter) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (filter.getMake() != null && !filter.getMake().isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("make")),
                        "%" + filter.getMake().toLowerCase(Locale.ROOT) + "%"
                ));
            }

            if  (filter.getModel() != null && !filter.getModel().isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("model")),
                        "%" + filter.getModel().toLowerCase(Locale.ROOT) + "%"
                ));
            }

            if (filter.getMinPrice() != null) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.greaterThanOrEqualTo(root.get("price"), filter.getMinPrice()));
            }

            if (filter.getMaxPrice() != null) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.lessThanOrEqualTo(root.get("price"), filter.getMaxPrice()));
            }

            return predicate;
        };
    }
}
