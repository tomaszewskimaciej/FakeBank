package com.fake.bank.backend.app;

import com.fake.bank.backend.app.config.YamlPropertySourceFactory;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"com.fake.bank"})
@EntityScan({"com.fake.bank.backend.integration.entity"})
@EnableJpaRepositories("com.fake.bank.backend.integration.repository")
@PropertySources({
        @PropertySource(value = "classpath:integration.yaml", factory = YamlPropertySourceFactory.class),
        @PropertySource(value = "classpath:rest.yaml", factory = YamlPropertySourceFactory.class)
})
@OpenAPIDefinition(info = @Info(title = "Fake-Bank API", version = "0.1", description = "Fake-Bank Information"))
public class Application {

    private static final String SPRING_CONFIG_NAME = "spring.config.name";
    private static final String APPLICATION_NAME = "fakeBank";

    public static void main(String[] args) {
        System.setProperty(SPRING_CONFIG_NAME, APPLICATION_NAME);
        SpringApplication.run(Application.class, args);
    }
}