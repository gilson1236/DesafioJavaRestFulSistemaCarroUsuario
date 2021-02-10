package org.projeto.desafio.controller;

import java.util.List;

import org.projeto.desafio.modelo.Carro;
import org.projeto.desafio.repository.Carros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CarroController {
	
	@Autowired
	private Carros carros;
	
	@PostMapping(value = "/cars")
	public Carro cadastrar(@RequestBody Carro carro) {
		return this.carros.save(carro);
	}
		
	@GetMapping
	public List<Carro> listarTodosOsCarros() {
		return carros.findAll();
	}
	
	@GetMapping(value = "/cars/{id}")
	public ResponseEntity<Carro> encontrarCarro(@PathVariable long id) {
		return carros.findById(id).map(record->ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value = "/cars/{id}")
	public ResponseEntity <Carro> atualizar(@PathVariable("id") long id, @RequestBody Carro carro) {
		return carros.findById(id).map(record -> {record.setColor(carro.getColor());
			record.setLicensePlate(carro.getLicensePlate());
			record.setYear(carro.getYear());
			record.setModel(carro.getModel());
			Carro atualizado = carros.save(record);
			return ResponseEntity.ok().body(atualizado);
			}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(value="/cars/{id}")
	public ResponseEntity <?> remover(@PathVariable long id){
		return carros.findById(id).map(record -> {carros.deleteById(id);
				return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
}