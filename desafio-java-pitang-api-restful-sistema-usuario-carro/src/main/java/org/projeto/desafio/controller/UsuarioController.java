package org.projeto.desafio.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.projeto.desafio.modelo.Usuario;
import org.projeto.desafio.repository.Usuarios;
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
public class UsuarioController {
		
		@Autowired
		private Usuarios usuarios;
		
		@PostMapping("/users")
		@ResponseStatus(HttpStatus.CREATED)
		public Usuario cadastrar(@Valid @RequestBody Usuario usuario) {
			return this.usuarios.save(usuario);
		}
			
		@GetMapping("/users")
		public List<Usuario> listarTodosOsUsuarios() {
			return usuarios.findAll();
		}
		
		@GetMapping("/users/{id}")
		public ResponseEntity<Usuario> encontrarUsuario(@PathVariable Long id) {
			Optional<Usuario> usuario = usuarios.findById(id);
			
			if(usuario.isPresent()) {
				return ResponseEntity.ok(usuario.get());
			}
			
			return ResponseEntity.notFound().build();
		}
		
		@PutMapping("/users/{id}")
		public ResponseEntity <Usuario> atualizar(@Valid @PathVariable Long id, @RequestBody Usuario usuario) {
			
			if(!usuarios.existsById(id)) {
				return ResponseEntity.notFound().build();
			}
			
			usuario.setId(id);
			usuario = usuarios.save(usuario);
			
			return ResponseEntity.ok(usuario);
			
		}
		
		@DeleteMapping("/users/{id}")
		public ResponseEntity <Void> remover(@PathVariable Long id){
			if(!usuarios.existsById(id)) {
				return ResponseEntity.notFound().build();
			}
			
			return ResponseEntity.noContent().build();
		}
	
}
