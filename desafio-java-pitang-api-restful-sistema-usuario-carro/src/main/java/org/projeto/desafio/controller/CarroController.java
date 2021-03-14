package org.projeto.desafio.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.projeto.desafio.modelo.Carro;
import org.projeto.desafio.repository.Carros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api")
public class CarroController {
	
	@Autowired
	private Carros carros;
	
	@PostMapping("/cars")
	@ResponseStatus(HttpStatus.CREATED)
	public Carro cadastrar(@Valid @RequestBody Carro carro) {
		return this.carros.save(carro);
	}
		
	@GetMapping("/cars")
	public List<Carro> listarTodosOsCarros() {
		return carros.findAll();
	}
	
	@GetMapping("/cars/{id}")
	public ResponseEntity<Carro> encontrarCarro(@PathVariable Long id) {
		Optional<Carro> carro = carros.findById(id);
		
		if(carro.isPresent()) {
			return ResponseEntity.ok(carro.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(value = "/cars/{id}")
	public ResponseEntity <Carro> atualizar(@Valid @PathVariable Long id, @RequestBody Carro carro) {
		
		if(!carros.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		carro.setId(id);
		carro = carros.save(carro);
		
		return ResponseEntity.ok(carro);
		
	}
	
	@DeleteMapping(value="/cars/{id}")
	public ResponseEntity <Void> remover(@PathVariable Long id){
		if(!carros.existsById(id)) {
			ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}
}