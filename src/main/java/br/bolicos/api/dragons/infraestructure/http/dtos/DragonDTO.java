package br.bolicos.api.dragons.infraestructure.http.dtos;

import java.util.UUID;

public record DragonDTO(UUID id, String name, String breed, Integer age, Integer size, String power, String status) {
}
