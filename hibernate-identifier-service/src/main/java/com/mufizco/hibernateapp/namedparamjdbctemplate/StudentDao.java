package com.mufizco.hibernateapp.namedparamjdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.Random;

public class StudentDao {

    private final DataSource dataSource;

    public StudentDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void updateStudentByFirstName(String firstName) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        Random random = new Random();
        String lastName = "named_param" + random.nextInt(10000);
        String sql = "update uofu.STUDENT set last_name=:lastname where first_name=:firstname";
        MapSqlParameterSource paramMap = new MapSqlParameterSource();
        paramMap.addValue("firstname", firstName);
        paramMap.addValue("lastname", lastName);
        namedParameterJdbcTemplate.update(sql, paramMap);
    }
}
