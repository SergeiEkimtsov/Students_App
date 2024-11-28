package com.ekimtsovss.students_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;

import javax.sql.DataSource;

@Configuration
public class ConfigStudent {

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
    @Bean
    public DataSource dataSource(){
        String url = "jdbc:postgresql://localhost:5432/First_DB";
        String name = "postgres";
        String password = "user";
        String driver = "org.postgresql.Driver";

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(name);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driver);

        return dataSource;

    }



}
