package br.bolicos.api.dragons.infraestructure.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface AbstractRepository<D> extends JpaRepository<D, UUID> {
}
