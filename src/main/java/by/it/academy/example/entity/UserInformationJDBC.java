package by.it.academy.example.entity;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class UserInformationJDBC {
    private final Logger logger = LoggerFactory.getLogger("LOGS");
    private final HikariConfig config = new HikariConfig();
    private final DataSource ds;

     {
        config.setDriverClassName(UserParameters.getJdbcDriver());
        config.setJdbcUrl( UserParameters.getUrl() );
        config.setUsername( UserParameters.getUsername() );
        config.setPassword( UserParameters.getPassword() );
        config.setMaxLifetime(2000);
        config.setMaximumPoolSize(20);
        ds = new HikariDataSource(config);
    }

    @Bean
    public Connection getPoolConnection (){
        try {logger.trace("getConnection success");
            return ds.getConnection();
        } catch (SQLException e) {
            logger.error("There was an error in the class UserInformationJDBC",e);
            return null;
        }
    }
}
@Component
@PropertySource("classpath:jdbc.properties")
class UserParameters {
    @Getter @Setter
    @Value("${driverClassName}")
    static String jdbcDriver;
    @Getter @Setter
    @Value("${jdbcUrl}")
    static String url;
    @Getter @Setter
    @Value("${username}")
    static String username;
    @Getter @Setter
    @Value("${password}")
    static String password;
}

