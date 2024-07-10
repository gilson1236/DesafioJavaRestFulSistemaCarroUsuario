package org.projeto.desafio.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.projeto.desafio.dto.CarDTO;
import org.projeto.desafio.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class CarController {

	private final CarService carService;

	public CarController(CarService carService){
		this.carService = carService;
	}
	
	@PostMapping("/cars")
	@ResponseStatus(HttpStatus.CREATED)
	public CarDTO create(@Valid @RequestBody CarDTO carro) {
		return this.carService.create(carro);
	}
		
	@GetMapping("/cars")
	public List<CarDTO> listCars() {
		return carService.read();
	}
	
	@GetMapping("/cars/{id}")
	public CarDTO findCar(@PathVariable Long id) {
		return carService.readById(id);
	}
	
	@PutMapping(value = "/cars/{id}")
	public CarDTO atualizar(@Valid @PathVariable Long id, @RequestBody CarDTO car) {
		
		return carService.update(id, car);
		
	}
	
	@DeleteMapping(value="/cars/{id}")
	public void remove(@PathVariable Long id) {
		carService.delete(id);
	}
}