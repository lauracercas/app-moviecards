//package com.lauracercas.moviecards.integrationtest;
//
//import org.flywaydb.core.Flyway;
//import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FlywayTestConfiguration {
//
//    @Bean
//    public Flyway flyway() {
//        Flyway flyway = Flyway.configure()
//                .dataSource("jdbc:mysql://localhost:3306/moviesdb_test", "test", "testpassword")
//                .locations("classpath:db/migration")
//                .load();
//        flyway.migrate();
//        return flyway;
//    }
//}
