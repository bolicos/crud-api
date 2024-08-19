package br.bolicos.api.dragons;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@Tag("integration")
@ActiveProfiles("test")
class ApplicationTests {

    @Test
    void contextLoads() {
    }
}
