package br.bolicos.api.dragons.infraestructure.http.controllers;

import br.bolicos.api.dragons.application.usecases.DragonService;
import br.bolicos.api.dragons.infraestructure.http.dtos.DragonDTO;
import br.bolicos.api.dragons.infraestructure.http.dtos.DragonDTOWithoutId;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/dragons")
public class DragonController {
    private DragonService dragonService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<DragonDTO> createDragon(@RequestBody DragonDTOWithoutId dto) {
        var dragon = dragonService.create(dto.toDomain());

        return Mono.just(DragonDTO.toDTO(dragon));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<DragonDTO> getDragon(@PathVariable UUID id) {
        var dragon = dragonService.get(id);

        return Mono.just(DragonDTO.toDTO(dragon));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<DragonDTO> getAllDragons() {
        var dragons = dragonService.getAll();
        var dragonsDTOs = dragons.stream().map(DragonDTO::toDTO);

        return Flux.fromStream(dragonsDTOs);
    }

    @GetMapping("/byKingdom")
    @ResponseStatus(HttpStatus.OK)
    public Flux<DragonDTO> getDragonsByKingdom(@RequestParam UUID kingdomId) {
        var dragons = dragonService.getByKingdom(kingdomId);
        var dragonsDTOs = dragons.stream().map(DragonDTO::toDTO);

        return Flux.fromStream(dragonsDTOs);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDragon(@PathVariable UUID id) {
        dragonService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<DragonDTO> updateDragon(@PathVariable UUID id, @RequestBody DragonDTO dto) {
        var dragon = dragonService.update(id, dto.toDomain());

        return Mono.just(DragonDTO.toDTO(dragon));
    }
}
