package io.github.henrik13.usedcarmarket.service;

import io.github.henrik13.usedcarmarket.model.Car;
import io.github.henrik13.usedcarmarket.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> findById(Integer id) {
        return carRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        carRepository.deleteById(id);
    }

    @Override
    public Collection<Car> findAll() {
        return carRepository.findAll();
    }
}
