package com.quesito.struts.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;


@ApplicationScoped
public class DatabaseConfig {

    @ApplicationScoped
    @Produces
    public DataSource dataSource() {
        String hikariPath = this.getClass().getClassLoader().getResource("hikari.properties").getPath();
        HikariConfig hikariConfig = new HikariConfig(hikariPath);
        return new HikariDataSource(hikariConfig);
    }

    @Produces
    @ApplicationScoped
    public NamedParameterJdbcOperations jdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
