package io.github.henrik13.usedcarmarket.repository;

import io.github.henrik13.usedcarmarket.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}
