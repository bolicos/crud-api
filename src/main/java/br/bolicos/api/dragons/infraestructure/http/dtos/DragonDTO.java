package br.bolicos.api.dragons.infraestructure.http.dtos;

import br.bolicos.api.dragons.domain.dragon.Dragon;

import java.util.UUID;

public record DragonDTO(
        UUID id,
        String name,
        String breed,
        Integer age,
        Integer size,
        String power,
        String strength,
        String element,
        String health,
        String status,
        Boolean canFly
) {
    public Dragon toDomain() {
        return new Dragon.Builder(this.id, this.name, this.breed, this.age, this.size)
                .withPower(this.power)
                .withStrength(this.strength)
                .withElement(this.element)
                .setHealth(this.health)
                .setStatus(this.status)
                .canFly(this.canFly)
                .build();
    }

    public static DragonDTO toDTO(Dragon domain) {
        return new DragonDTO(
                domain.id(),
                domain.name(),
                domain.breed(),
                domain.age(),
                domain.size(),
                domain.power(),
                domain.strength(),
                domain.element(),
                domain.health(),
                domain.status(),
                domain.canFly()
        );
    }

}
