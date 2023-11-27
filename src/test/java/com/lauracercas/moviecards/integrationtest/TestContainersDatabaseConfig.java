package com.lauracercas.moviecards.integrationtest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@ContextConfiguration(initializers = TestContainersDatabaseConfig.InitializadorDeContexto.class)
public abstract class TestContainersDatabaseConfig {

    @Container
    protected static final MySQLContainer<?> mysqlContainer2 = new MySQLContainer<>("mysql:latest")
            .withExposedPorts(3306);

    @Container
    private static final MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:latest")
            .withDatabaseName("moviesdb_test")
            .withUsername("test")
            .withPassword("testpassword")
            .withExposedPorts(3306);

    @BeforeAll
    static void inicializarContenedor() {
        mysqlContainer.start();
    }

    @AfterAll
    static void detenerContenedor() {
        mysqlContainer.stop();
    }

    static class InitializadorDeContexto implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            Integer mappedPort = mysqlContainer.getMappedPort(3306);
            String jdbcUrl = "jdbc:mysql://localhost:" + mappedPort + "/moviesdb_test";

            // Configurar las propiedades del contenedor en el entorno de prueba
            TestPropertyValues.of(
                    "spring.datasource.url=" + jdbcUrl,
                    "spring.datasource.username=" + mysqlContainer.getUsername(),
                    "spring.datasource.password=" + mysqlContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }
}