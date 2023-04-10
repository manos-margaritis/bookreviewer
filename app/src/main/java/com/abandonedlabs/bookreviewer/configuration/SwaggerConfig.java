package com.abandonedlabs.bookreviewer.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Swagger config.
 */
@OpenAPIDefinition
@Configuration
public class SwaggerConfig {

    /**
     * Base open api open api.
     *
     * @return the open api
     */
    @Bean
    public OpenAPI baseOpenAPI() {

        return new OpenAPI()
                .info(new Info().title("Book Reviewer").version("1.0.0").description("Book Reviewer Swagger"));
    }
}
