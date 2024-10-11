package com.ekimtsovss.students_app.service;

import com.ekimtsovss.students_app.entity.Student;

import java.util.List;

public interface StudentServiceDAO {
    List<Student> getAllStudents();
    void saveStudent(Student student);

    Student getStudent(int id);
    void updateStudent(Student student);
    void deleteStudent(int id);
}
