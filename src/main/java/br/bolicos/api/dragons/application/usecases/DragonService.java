package br.bolicos.api.dragons.application.usecases;

import br.bolicos.api.dragons.application.repositories.DragonRepository;
import br.bolicos.api.dragons.domain.dragon.Dragon;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static br.bolicos.api.dragons.application.utils.Utils.isTrueOrElseThrowBadRequest;

@Service
@AllArgsConstructor
public class DragonService {
    private final DragonRepository dragonRepository;

    public Dragon get(UUID id) {
        return this.dragonRepository.get(id);
    }

    public Dragon create(Dragon dragon) {
        return this.dragonRepository.create(dragon);
    }

    public List<Dragon> getAll() {
        return this.dragonRepository.findAll();
    }

    public void delete(UUID id) {
        this.dragonRepository.delete(id);
    }

    public Dragon update(UUID id, Dragon dragon) {
        var condition = id.equals(dragon.id());
        var message = "ID mismatch: the ID in the URL does not match the ID sent in the request body.";
        Throwable throwable = new IllegalArgumentException(message);

        isTrueOrElseThrowBadRequest(condition, throwable);

        return this.dragonRepository.update(dragon, id);
    }

    public List<Dragon> getByKingdom(UUID kingdomId) {
        return this.dragonRepository.findAllByKingdom(kingdomId);
    }
}
