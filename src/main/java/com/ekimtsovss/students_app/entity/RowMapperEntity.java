package com.ekimtsovss.students_app.entity;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class RowMapperEntity implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();

        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setSurname(rs.getString("surname"));
        student.setMobile(rs.getString("mobile"));
        return student;
    }
}
