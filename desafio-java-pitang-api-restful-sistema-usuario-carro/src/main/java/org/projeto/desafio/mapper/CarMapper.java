package org.projeto.desafio.mapper;

import org.projeto.desafio.dto.CarDTO;
import org.projeto.desafio.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public Car toModel(CarDTO carDTO){
        Car car = new Car();

        car.setModel(carDTO.model());
        car.setColor(carDTO.color());
        car.setYear(carDTO.year());
        car.setLicensePlate(carDTO.licensePlate());

        return car;
    }

    public CarDTO toDTO(Car car){
        if(car == null){
            return null;
        }

        return new CarDTO(car.getId(), car.getYear(), car.getLicensePlate(), car.getModel(), car.getColor());
    }
}
