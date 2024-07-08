package org.projeto.desafio.service;

import org.projeto.desafio.dto.UserDTO;
import org.projeto.desafio.exceptions.RecordAlreadyExistsException;
import org.projeto.desafio.exceptions.RecordNotFoundException;
import org.projeto.desafio.mapper.CarMapper;
import org.projeto.desafio.mapper.UserMapper;
import org.projeto.desafio.model.User;
import org.projeto.desafio.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO create(UserDTO userRequest){
        userRepository.findByEmail(userRequest.email()).stream()
                .findAny().ifPresent(u -> {
                    throw new RecordAlreadyExistsException("Email already exists");
                });
        User user = userMapper.toModel(userRequest);
        return userMapper.toDTO(userRepository.save(user));
    }

    public List<UserDTO> read(){
        return userRepository.findAll().stream()
                .map(userMapper::toDTO).toList();
    }

    public UserDTO readById(Long id){
        return userRepository.findById(id).map(userMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException("User not found"));
    }

    public UserDTO update(Long id, UserDTO user){
        CarMapper carMapper = new CarMapper();
        return userRepository.findById(id).map(toUpdate -> {
            toUpdate.setFirstName(user.firstName());
            toUpdate.setLastName(user.lastName());
            toUpdate.setEmail(user.email());
            toUpdate.setCars(user.cars().stream().map(carMapper::toModel).toList());
            toUpdate.setPassword(user.password());
            toUpdate.setLogin(user.login());
            toUpdate.setPhone(user.phone());
            toUpdate.setDataNascimento(user.dataNascimento());
            return userMapper.toDTO(userRepository.save(toUpdate));
        }).orElseThrow(() -> new RecordNotFoundException("User not found"));
    }

    public void delete(Long id){
        this.userRepository.delete(userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("User not found")));
    }
	
}
