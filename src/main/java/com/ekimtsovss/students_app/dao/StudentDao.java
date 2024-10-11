package com.ekimtsovss.students_app.dao;

import com.ekimtsovss.students_app.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents();
    void saveStudent(Student student);
    Student getStudent(int id);

    void updateStudent(Student student);
    void deleteStudent(int id);
}
