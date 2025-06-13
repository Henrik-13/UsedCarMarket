package io.github.henrik13.usedcarmarket.controller;

import io.github.henrik13.usedcarmarket.dto.indto.CarFilterDto;
import io.github.henrik13.usedcarmarket.dto.indto.CarInDto;
import io.github.henrik13.usedcarmarket.dto.outdto.CarOutDto;
import io.github.henrik13.usedcarmarket.exception.CarNotFoundException;
import io.github.henrik13.usedcarmarket.mapper.CarMapper;
import io.github.henrik13.usedcarmarket.model.Car;
import io.github.henrik13.usedcarmarket.service.CarService;
import io.github.henrik13.usedcarmarket.specification.CarFilter;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/ad")
@Slf4j
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private CarMapper carMapper;

    @GetMapping
    public Collection<CarOutDto> getCars() {
        log.info("GET /ad");
        Collection<Car> cars = carService.findAll();
        return carMapper.toDtoCollection(cars);
    }

    @GetMapping("/{id}")
    public CarOutDto getCar(@PathVariable Integer id) throws CarNotFoundException {
        log.info("GET /ad/{}", id);
        Car car = carService.findById(id);
        return carMapper.toDto(car);
    }

    @GetMapping("/search")
    public Collection<CarOutDto> getCars(CarFilterDto filterDto) {
        log.info("GET /ad/search");
        CarFilter carFilter = CarFilter.builder()
                .model(filterDto.getModel())
                .make(filterDto.getMake())
                .minPrice(filterDto.getMinPrice())
                .maxPrice(filterDto.getMaxPrice())
                .build();
        return carMapper.toDtoCollection(carService.findFilteredCars(carFilter));
    }

    @PostMapping
    public CarOutDto createCar(@RequestBody @Valid CarInDto carInDto) {
        log.info("POST /ad");
        Car savedCar = carService.save(carMapper.toCar(carInDto));
        return carMapper.toDto(savedCar);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Integer id) throws CarNotFoundException {
        log.info("DELETE /ad/{}", id);
        carService.deleteById(id);
    }

    @PutMapping("/{id}")
    public CarOutDto updateCar(@PathVariable Integer id, @RequestBody @Valid CarInDto carInDto)
            throws CarNotFoundException {
        log.info("PUT /ad/{}", id);
        Car updatedCar = carService.update(id, carMapper.toCar(carInDto));
        return carMapper.toDto(updatedCar);
    }
}
