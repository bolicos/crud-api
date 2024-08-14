package br.bolicos.api.dragons.application.repositories;

import br.bolicos.api.dragons.domain.dragon.Dragon;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DragonRepository {
    Dragon get(UUID id);
    Dragon save(Dragon domain);
    Dragon update(Dragon domain, UUID id);
    UUID delete(UUID id);
}
