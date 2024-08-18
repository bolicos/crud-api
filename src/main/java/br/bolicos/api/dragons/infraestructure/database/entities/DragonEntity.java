package br.bolicos.api.dragons.infraestructure.database.entities;

import br.bolicos.api.dragons.domain.dragon.Dragon;
import br.bolicos.api.dragons.infraestructure.database.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DRAGONS")
public class DragonEntity extends AbstractEntity<UUID> {
    @Id
    private UUID id;
    private String name;
    private String breed;
    private Integer age;
    private Integer size;
    private String power;
    private String strength;
    private String element;
    private String health;
    private String status;
    private Boolean canFly;

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

    public static DragonEntity toEntity(Dragon domain) {
        return new DragonEntity(
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

    public void update(Dragon domain) {
        this.id = domain.id();
        this.name = domain.name();
        this.breed = domain.breed();
        this.age = domain.age();
        this.size = domain.size();
        this.power = domain.power();
        this.strength = domain.strength();
        this.health = domain.health();
        this.element = domain.element();
        this.status = domain.status();
        this.canFly = domain.canFly();
    }

    @Override
    public UUID getId() {
        return this.id;
    }
}