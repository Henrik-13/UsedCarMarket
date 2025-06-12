package io.github.henrik13.usedcarmarket.service;

import io.github.henrik13.usedcarmarket.exception.CarNotFoundException;
import io.github.henrik13.usedcarmarket.model.Car;

import java.util.Collection;

public interface CarService {
    Car save(Car car);

    Car findById(Integer id) throws CarNotFoundException;

    void deleteById(Integer id) throws CarNotFoundException;

    Collection<Car> findAll();

    Car update(Integer id, Car car) throws CarNotFoundException;
}
