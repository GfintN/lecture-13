package by.it.academy.example.entity;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlyWayMigration {

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return flyway -> {};
    }

    @Autowired (required = false)
    private Flyway flyway;

    public void skipAutomaticAndTriggerManualFlywayMigration() {
        flyway.migrate();
    }

}
