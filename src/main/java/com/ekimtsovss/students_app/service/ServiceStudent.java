package com.ekimtsovss.students_app.service;

import com.ekimtsovss.students_app.dao.StudentDaoImpl;
import com.ekimtsovss.students_app.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceStudent implements StudentServiceDAO {
    @Autowired
    StudentDaoImpl studentDao;
    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public void saveStudent(Student student) {
        studentDao.saveStudent(student);

    }

    @Override
    public Student getStudent(int id) {
        return studentDao.getStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);

    }

    @Override
    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }
}
