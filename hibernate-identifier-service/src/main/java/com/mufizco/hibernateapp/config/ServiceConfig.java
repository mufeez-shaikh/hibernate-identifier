package com.mufizco.hibernateapp.config;

import com.mufizco.hibernateapp.namedparamjdbctemplate.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class ServiceConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    public StudentDao getStudentDao() {
        return new StudentDao(dataSource);
    }

}
