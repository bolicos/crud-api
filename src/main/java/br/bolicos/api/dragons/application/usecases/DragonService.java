package br.bolicos.api.dragons.application.usecases;

import br.bolicos.api.dragons.domain.dragon.Dragon;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DragonService {
    public Dragon get(UUID id) {
        return null;
    }

    public Dragon create(Dragon dragon) {
        return null;
    }

    public List<Dragon> getAll() {
        return List.of();
    }

    public Dragon delete(UUID id) {
        return null;
    }

    public Dragon update(UUID id, Dragon dragon) {
        return null;
    }

    public List<Dragon> getByKingdom(UUID kingdomId) {
        return List.of();
    }
}
