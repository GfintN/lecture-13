package by.it.academy.example;

import by.it.academy.example.dao.JdbcTestDbDaoImpl;
import by.it.academy.example.entity.FlyWayMigration;
import by.it.academy.example.service.JdbcTestDbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] ar) {
        final Logger logger = LoggerFactory.getLogger("LOGS");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("by.it.academy.example");
        JdbcTestDbDaoImpl jdbcTestDbDao = applicationContext.getBean(JdbcTestDbDaoImpl.class);
        jdbcTestDbDao.openConnection();
        logger.trace("jdbcTestDbImpl open connection complete");
        JdbcTestDbService jdbcTestDbService = applicationContext.getBean(JdbcTestDbService.class);
        jdbcTestDbService.addData("1","Bob","11");
        logger.trace("jdbcTestDbService Insert complete");
        try {
            FlyWayMigration flyWayMigration = new FlyWayMigration();
            flyWayMigration.flywayMigrationStrategy();
            flyWayMigration.skipAutomaticAndTriggerManualFlywayMigration();
        }catch (NullPointerException e) {
            logger.error("FlyWayMigration null pointer");
        }logger.trace("FlyWayMigration complete");
        jdbcTestDbDao.closeConnection();
        logger.trace("jdbcTestDbImpl close connection complete");
    }
}
