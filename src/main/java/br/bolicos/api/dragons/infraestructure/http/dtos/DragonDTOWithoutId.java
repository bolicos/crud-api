package br.bolicos.api.dragons.infraestructure.http.dtos;

import br.bolicos.api.dragons.domain.dragon.Dragon;

public record DragonDTOWithoutId(
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
        return new Dragon.Builder(this.name, this.breed, this.age, this.size)
                .withPower(this.power)
                .withStrength(this.strength)
                .withElement(this.element)
                .setHealth(this.health)
                .setStatus(this.status)
                .canFly(this.canFly)
                .build();
    }
}
