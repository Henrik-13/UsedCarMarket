package io.github.henrik13.usedcarmarket.service;

import io.github.henrik13.usedcarmarket.exception.CarNotFoundException;
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
    public Car findById(Integer id) throws CarNotFoundException {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isEmpty()) {
            throw new CarNotFoundException("Car with id " + id + " not found.");
        }
        return carOptional.get();
    }

    @Override
    public void deleteById(Integer id) throws CarNotFoundException {
        if (!carRepository.existsById(id)) {
            throw new CarNotFoundException("Car with id " + id + " not found.");
        }
        carRepository.deleteById(id);
    }

    @Override
    public Collection<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car update(Integer id, Car car) throws CarNotFoundException {
        if (carRepository.existsById(id)) {
            car.setId(id);
            return carRepository.save(car);
        } else {
            throw new CarNotFoundException("Car with id " + id + " not found.");
        }
    }
}
