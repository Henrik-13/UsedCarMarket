package io.github.henrik13.usedcarmarket.service;

import io.github.henrik13.usedcarmarket.model.Car;

import java.util.Collection;
import java.util.Optional;

public interface CarService {
    Car save(Car car);

    Optional<Car> findById(Integer id);

    void deleteById(Integer id);

    Collection<Car> findAll();
}
