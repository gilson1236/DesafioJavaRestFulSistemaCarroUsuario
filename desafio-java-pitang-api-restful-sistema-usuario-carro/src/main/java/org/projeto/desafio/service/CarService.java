package org.projeto.desafio.service;

import org.projeto.desafio.dto.CarDTO;
import org.projeto.desafio.exceptions.RecordAlreadyExistsException;
import org.projeto.desafio.exceptions.RecordNotFoundException;
import org.projeto.desafio.mapper.CarMapper;
import org.projeto.desafio.model.Car;
import org.projeto.desafio.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarService(CarRepository carRepository, CarMapper carMapper){
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public CarDTO create(CarDTO carRequest){
        carRepository.findByLicensePlate(carRequest.licensePlate())
                .stream().findAny().ifPresent(c -> {
                    throw new RecordAlreadyExistsException("License plate already exists");
                });
        Car car = carMapper.toModel(carRequest);
        return carMapper.toDTO(carRepository.save(car));
    }

    public List<CarDTO> read(){
        return carRepository.findAll().stream().map(
                carMapper::toDTO
        ).collect(Collectors.toList());
    }

    public CarDTO readById(Long id){
        return carRepository.findById(id).map(carMapper::toDTO).orElseThrow(
                () -> new RecordNotFoundException("Car not found")
        );
    }

    public CarDTO update(Long id, CarDTO car){
        return carRepository.findById(id).map(atual -> {
            atual.setModel(car.model());
            atual.setColor(car.color());
            atual.setLicensePlate(car.licensePlate());
            atual.setYear(car.year());
            return carMapper.toDTO(carRepository.save(atual));
        }).orElseThrow(() -> new RecordNotFoundException("Car not found"));
    }

    public void delete(Long id){
        this.carRepository.delete(carRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Car not found")));
    }
}
