package com.ekimtsovss.students_app.controller;

import com.ekimtsovss.students_app.dao.StudentDaoImpl;
import com.ekimtsovss.students_app.entity.Student;
import com.ekimtsovss.students_app.service.ServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class StudentsController {
    @Autowired
    private ServiceStudent serviceStudent;

    @GetMapping("/getAll")
    public String showAllStudents(Model model){
        LocalDateTime localDateTime = LocalDateTime.now();
        var time = localDateTime.toString();
        var students = serviceStudent.getAllStudents();

        model.addAttribute("titlePage", "Student List");
        model.addAttribute("localDateTime", localDateTime);
        model.addAttribute("students", students);
        return "testView";
    }
    @GetMapping("/application")
    public String application(Model model){
        System.out.println("application");
        Student student = new Student();
        model.addAttribute("student", student);
        return "student_application";
    }
    @PostMapping("/saveStudent")
    public String saveStudent(@RequestParam int id,
                              @RequestParam String name,
                              @RequestParam String surname,
                              @RequestParam long mobile){
        System.out.println(name+surname+mobile);

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setSurname(surname);
        student.setMobile(mobile);

        if (student.getId()==0)
            serviceStudent.saveStudent(student);
        else serviceStudent.updateStudent(student);

        return "redirect:/getAll";
    }
    @GetMapping("/updateStudent")
    public String updateStudent(@RequestParam int id,
                                Model model){

        Student student = serviceStudent.getStudent(id);
        model.addAttribute("student", student);

        return "student_application";
    }
    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam int id){
        serviceStudent.deleteStudent(id);
        return "redirect:/getAll";
    }
    @GetMapping("/checkDelete")
    public String checkDelete(@RequestParam int id, Model model){

        model.addAttribute("id",id);

        return "deleteWindow";
    }
}
