package br.bolicos.api.dragons.infraestructure.database.repositories;

import br.bolicos.api.dragons.application.repositories.DragonRepository;
import br.bolicos.api.dragons.application.annotations.RepositoryImpl;
import br.bolicos.api.dragons.application.exceptions.NotFoundApiException;
import br.bolicos.api.dragons.domain.dragon.Dragon;
import br.bolicos.api.dragons.infraestructure.database.daos.DragonDAO;
import br.bolicos.api.dragons.infraestructure.database.entities.DragonEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@RepositoryImpl
@AllArgsConstructor
public class DragonRepositoryImpl implements DragonRepository {
    private final DragonDAO dao;

    @Override
    public Dragon get(UUID id) {
        var entity = this.dao.findById(id).orElseThrow(NotFoundApiException::new);

        return entity.toDomain();
    }

    @Override
    public Dragon create(Dragon domain) {
        var entity = DragonEntity.toEntity(domain);
        var saved = this.dao.save(entity);

        return saved.toDomain();
    }

    @Override
    public Dragon update(Dragon domain, UUID id) {
        var entity = this.dao.findById(id).orElseThrow(NotFoundApiException::new);
        entity.update(domain);

        return this.dao.save(entity).toDomain();
    }

    @Override
    public void delete(UUID id) {
        if (this.dao.isAbsentById(id)) {
            throw new NotFoundApiException();
        }

        this.dao.deleteById(id);
    }

    @Override
    public List<Dragon> findAll() {
        return this.dao.findAllByOrderByNameAsc().stream().map(DragonEntity::toDomain).toList();
    }

    @Override
    public List<Dragon> findAllByKingdom(UUID kingdomId) {
        return this.dao.findAll().stream().map(DragonEntity::toDomain).toList();
    }
}
