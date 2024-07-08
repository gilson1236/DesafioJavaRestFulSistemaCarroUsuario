package org.projeto.desafio.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "\"user\"")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank
	@Email
	@Size(max = 255)
	@Column(name = "email")
	private String email;

	@Column(name = "data_nascimento")
	private Calendar dataNascimento;
	
	@NotBlank
	@Size(max = 60)
	@Column(name = "login")
	private String login;
	
	@NotBlank
	@Column(name = "password")
	private String password;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "phone")
	private String phone;
	
	@OneToMany
	private List<Car> cars = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	
}
