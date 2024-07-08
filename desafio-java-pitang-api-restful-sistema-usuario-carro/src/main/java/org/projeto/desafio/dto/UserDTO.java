package org.projeto.desafio.dto;

import java.util.Calendar;
import java.util.List;

public record UserDTO(Long id, String firstName, String lastName,
        String email, Calendar dataNascimento, String login, String password,
        String phone, List<CarDTO> cars) {
}
