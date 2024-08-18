package br.bolicos.api.dragons.application.repositories;

import br.bolicos.api.dragons.domain.dragon.Dragon;

import java.util.List;
import java.util.UUID;

public interface DragonRepository {

    Dragon get(UUID id);

    Dragon create(Dragon domain);

    Dragon update(Dragon domain, UUID id);

    void delete(UUID id);

    List<Dragon> findAll();

    List<Dragon> findAllByKingdom(UUID kingdomId);
}
