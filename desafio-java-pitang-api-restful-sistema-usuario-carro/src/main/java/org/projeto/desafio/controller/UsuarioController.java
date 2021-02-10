package org.projeto.desafio.controller;

import java.util.List;

import org.projeto.desafio.modelo.Usuario;
import org.projeto.desafio.repository.Usuarios;
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
public class UsuarioController {
		
		@Autowired
		private Usuarios usuarios;
		
		@PostMapping(value = "/users")
		public Usuario cadastrar(@RequestBody Usuario usuario) {
			return this.usuarios.save(usuario);
		}
			
		@GetMapping
		public List<Usuario> listarTodosOsUsuarios() {
			return usuarios.findAll();
		}
		
		@GetMapping(value = "/users/{id}")
		public ResponseEntity<Usuario> encontrarUsuario(@PathVariable long id) {
			return usuarios.findById(id).map(record->ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
		}
		
		@PutMapping(value = "/users/{id}")
		public ResponseEntity <?> atualizar(@PathVariable("id") long id, @RequestBody Usuario usuario) {
			return usuarios.findById(id).map(record -> {record.setFirstName(usuario.getFirstName());
				record.setLastName(usuario.getLastName());
				record.setLogin(usuario.getLogin());
				record.setPassword(usuario.getPassword());
				record.setDataNascimento(usuario.getDataNascimento());
				record.setEmail(usuario.getEmail());
				record.setPhone(usuario.getPhone());
				record.setCars(usuario.getCars());
				Usuario atualizado = usuarios.save(record);
				return ResponseEntity.ok().body(atualizado);
				}).orElse(ResponseEntity.notFound().build());
		}
		
		@DeleteMapping(value="/users/{id}")
		public ResponseEntity <?> remover(@PathVariable long id){
			return usuarios.findById(id).map(record -> {usuarios.deleteById(id);
					return ResponseEntity.ok().build();
					}).orElse(ResponseEntity.notFound().build());
		}
	
}
