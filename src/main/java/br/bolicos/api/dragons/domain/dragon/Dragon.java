package br.bolicos.api.dragons.domain.dragon;

import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Accessors(fluent = true)
public class Dragon {
    private UUID id;
    private String name;
    private String breed;
    private Integer age;
    private Integer size;
    private String power;
    private String strength;
    private String health;
    private String element;
    private String status;
    private Boolean canFly;

    private Dragon(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.breed = builder.breed;
        this.age = builder.age;
        this.size = builder.size;
        this.power = builder.power;
        this.strength = builder.strength;
        this.health = builder.health;
        this.element = builder.element;
        this.status = builder.status;
        this.canFly = builder.canFly;
    }

    public static class Builder {
        private UUID id;
        private String name;
        private String breed;
        private Integer age;
        private Integer size;
        private String power;
        private String strength;
        private String health;
        private String element;
        private String status;
        private Boolean canFly;

        public Builder(String name, String breed, Integer age, Integer size) {
            this.id = UUID.randomUUID();
            this.name = name;
            this.breed = breed;
            this.age = age;
            this.size = size;
        }

        public Builder(UUID id, String name, String breed, Integer age, Integer size) {
            this.id = id;
            this.name = name;
            this.breed = breed;
            this.age = age;
            this.size = size;
        }

        public Builder withPower(String power) {
            this.power = power;
            return this;
        }

        public Builder withStrength(String strength) {
            this.strength = strength;
            return this;
        }

        public Builder setHealth(String health) {
            this.health = health;
            return this;
        }

        public Builder withElement(String element) {
            this.element = element;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder canFly(boolean canFly) {
            this.canFly = canFly;
            return this;
        }

        public Builder omitId() {
            this.id = null;
            return this;
        }

        public Dragon build() {
            return new Dragon(this);
        }
    }
}
