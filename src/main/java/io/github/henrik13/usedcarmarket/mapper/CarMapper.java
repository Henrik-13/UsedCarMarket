package io.github.henrik13.usedcarmarket.mapper;

import io.github.henrik13.usedcarmarket.dto.indto.CarInDto;
import io.github.henrik13.usedcarmarket.dto.outdto.CarOutDto;
import io.github.henrik13.usedcarmarket.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class CarMapper {
    public abstract CarOutDto toDto(Car car);

    @Mapping(target = "id", ignore = true)
    public abstract Car toCar(CarInDto carInDto);

    public abstract Collection<CarOutDto> toDtoCollection(Collection<Car> cars);
}
