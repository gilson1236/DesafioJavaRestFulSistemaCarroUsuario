package org.projeto.desafio.mapper;

import org.projeto.desafio.dto.CarDTO;
import org.projeto.desafio.dto.UserDTO;
import org.projeto.desafio.model.Car;
import org.projeto.desafio.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User toModel(UserDTO userDTO){
        User user = new User();
        CarMapper carMapper = new CarMapper();

        user.setEmail(user.getEmail());
        user.setDataNascimento(userDTO.dataNascimento());
        user.setPassword(userDTO.password());
        user.setLogin(userDTO.login());
        user.setFirstName(userDTO.firstName());
        user.setLastName(userDTO.lastName());
        user.setPhone(userDTO.phone());

        List<Car> list = userDTO.cars()
                .stream()
                .map(carDTO -> {
                    Car car = new Car();
                    car = carMapper.toModel(carDTO);
                    return car;
                }).toList();

        user.setCars(list);

        return user;
    }

    public UserDTO toDTO(User user){
        CarMapper carMapper = new CarMapper();
        if (user == null) {
            return null;
        }
        List<CarDTO> carDTOList = user.getCars().stream().map(car ->
            new CarDTO(car.getId(), car.getYear(), car.getLicensePlate(), car.getModel(), car.getColor())
        ).toList();

        return new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getDataNascimento(),
                user.getLogin(), user.getPassword(), user.getPhone(), carDTOList);
    }
}
