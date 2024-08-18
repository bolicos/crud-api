package br.bolicos.api.dragons.infraestructure.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TRAINERS")
public class TrainerEntity {
    @Id
    private UUID id;
    private String name;
}
