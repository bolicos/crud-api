package br.bolicos.api.dragons.infraestructure.database.daos;

import br.bolicos.api.dragons.infraestructure.database.AbstractRepository;
import br.bolicos.api.dragons.infraestructure.database.entities.DragonEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DragonDAO extends AbstractRepository<DragonEntity> {
    default boolean isAbsentById(UUID id) {
        return !this.existsById(id);
    }

    List<DragonEntity> findAllByOrderByNameAsc();
}
