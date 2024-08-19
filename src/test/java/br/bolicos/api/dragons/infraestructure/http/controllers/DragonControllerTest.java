package br.bolicos.api.dragons.infraestructure.http.controllers;

import br.bolicos.api.dragons.IntegrationTest;
import br.bolicos.api.dragons.application.usecases.DragonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static br.bolicos.api.dragons.Application.PATH_BASE;
import static org.mockito.Mockito.when;

@IntegrationTest(DragonController.class)
class DragonControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private DragonService dragonService;

    @Test
    void testEndpoint() {

        when(dragonService.getAll()).thenReturn(List.of());

        webTestClient.get().uri(PATH_BASE + "/dragons")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isEmpty();
    }
}