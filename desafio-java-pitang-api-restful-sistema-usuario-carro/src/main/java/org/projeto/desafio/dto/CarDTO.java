package org.projeto.desafio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CarDTO(@JsonProperty("_id") Long id, int year, String licensePlate, String model, String color) {
}
