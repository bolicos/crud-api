package br.bolicos.api.dragons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = "br.bolicos.api.dragons.setup")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
