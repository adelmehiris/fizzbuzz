package com.kata.fizzbuzz.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "FizzBuzz API",
                version = "1.0",
                description = "Documentation de l'API FizzBuzz"
        )
)
public class SwaggerConfig {
}

