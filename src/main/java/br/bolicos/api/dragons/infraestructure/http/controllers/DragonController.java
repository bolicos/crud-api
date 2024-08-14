package br.bolicos.api.dragons.infraestructure.http.controllers;

import br.bolicos.api.dragons.application.usecases.DragonService;
import br.bolicos.api.dragons.infraestructure.http.dtos.DragonDTO;
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
@RequestMapping("/api/dragons")
public class DragonController {
    private DragonService dragonService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<DragonDTO> createDragon(@RequestBody DragonDTO dto) {
        var dragon = dragonService.create(null);

        return Mono.empty();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<DragonDTO> getDragon(@PathVariable UUID id) {
        var dragon = dragonService.get(id);

        return Mono.empty();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<DragonDTO> getAllDragons() {
        var dragons = dragonService.getAll();

        return Flux.empty();
    }

    @GetMapping("/byKingdom")
    @ResponseStatus(HttpStatus.OK)
    public Flux<DragonDTO> getDragonsByKingdom(@RequestParam UUID kingdomId) {
        var dragons = dragonService.getByKingdom(kingdomId);

        return Flux.empty();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDragon(@PathVariable UUID id) {
        dragonService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<DragonDTO> createDragon(@PathVariable UUID id, @RequestBody DragonDTO dto) {
        var dragon = dragonService.update(null, null);

        return Mono.empty();
    }
}
