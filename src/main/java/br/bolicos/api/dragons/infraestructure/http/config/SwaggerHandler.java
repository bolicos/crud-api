package br.bolicos.api.dragons.infraestructure.http.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerHandler {

    @Bean
    public OpenAPI springOpenAPI() {
        var version = "v0.0.1";
        var title = "Dragons API";
        var license = new License().name("MIT").url("https://springdoc.org");
        var description = """
                **Dragons API** allows you to efficiently manage dragons in a system.\s
                With this API, it is possible to create, update, view, and delete information about different types of dragons.\s
                """;
        var externalDoc = new ExternalDocumentation().description("Spring io").url("https://spring.io/");
        var info = new Info().title(title).description(description).version(version).license(license);

        return new OpenAPI().info(info).externalDocs(externalDoc);
    }

    @Bean
    public GroupedOpenApi openApi() {
        return GroupedOpenApi.builder().group("api").pathsToMatch("/api/**").build();
    }

    @Bean
    public GroupedOpenApi actuatorOpenApi() {
        return GroupedOpenApi.builder().group("actuator").pathsToMatch("/actuator/**").build();
    }
}
