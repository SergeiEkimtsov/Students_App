package com.ekimtsovss.students_app.dao;

import com.ekimtsovss.students_app.entity.RowMapperEntity;
import com.ekimtsovss.students_app.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private RowMapperEntity rowMapper;

    @Override
    public List<Student> getAllStudents() {

        String sql = "SELECT * from students";
        var listOfStudents = jdbcTemplate.query(sql, rowMapper);

        return listOfStudents;
    }

    @Override
    public void saveStudent(Student student) {
        String sqlInsert = "INSERT INTO students ( name, surname, mobile) "
                + "VALUES ( ?,?,?)";
        Object[] values = {student.getName(), student.getSurname(), student.getMobile()};
//        String sql = "INSERT INTO students ( name, surname, mobile) "
//                +"VALUES ( '"+student.getName()+"', '"+student.getSurname()+"','"+student.getMobile()+"')";

            jdbcTemplate.update(sqlInsert, values);

    }

    @Override
    public Student getStudent(int id) {
        String sql = "SELECT * from students WHERE id = ?";
        var student = jdbcTemplate.queryForObject(sql,rowMapper,id);
        return student;
    }

    @Override
    public void updateStudent(Student student) {
        String sqlUpdate = "UPDATE students set name = ?, surname = ?, mobile = ? where id = ?";
        jdbcTemplate.update(sqlUpdate,
                student.getName(), student.getSurname(), student.getMobile(), student.getId());
    }

    @Override
    public void deleteStudent(int id) {
        String sql = "DELETE from students WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }
}
