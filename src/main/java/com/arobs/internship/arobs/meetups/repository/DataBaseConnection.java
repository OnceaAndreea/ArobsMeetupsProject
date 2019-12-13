package com.arobs.internship.arobs.meetups.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnection {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    @Bean
    public HikariDataSource getDs() {
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost/meetups");
        config.setUsername("root");
        config.setPassword("pass");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        return ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


}
