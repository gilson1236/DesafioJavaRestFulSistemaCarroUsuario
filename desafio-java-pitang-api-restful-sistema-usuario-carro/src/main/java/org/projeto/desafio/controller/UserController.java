package org.projeto.desafio.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.projeto.desafio.dto.UserDTO;
import org.projeto.desafio.service.UserService;
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
@RequestMapping("/api")
public class UserController {

		private final UserService userService;

		public UserController(UserService userService){
			this.userService = userService;
		}

		@PostMapping("/sigin")
		void login(){
			System.out.println("Logado");
		}
		
		@PostMapping("/users")
		@ResponseStatus(HttpStatus.CREATED)
		public UserDTO create(@Valid @RequestBody UserDTO user) {
			return this.userService.create(user);
		}
			
		@GetMapping("/users")
		public List<UserDTO> list() {
			return userService.read();
		}
		
		@GetMapping("/users/{id}")
		public UserDTO findRecord(@PathVariable Long id) {
			return userService.readById(id);
		}
		
		@PutMapping("/users/{id}")
		public UserDTO updateRecord(@Valid @PathVariable Long id, @RequestBody UserDTO user) {
			
			 return userService.update(id, user);
			
		}
		
		@DeleteMapping("/users/{id}")
		@ResponseStatus(code = HttpStatus.NO_CONTENT)
		public void remover(@PathVariable Long id){
			userService.delete(id);
		}
	
}
