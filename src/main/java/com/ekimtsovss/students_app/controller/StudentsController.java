package com.ekimtsovss.students_app.controller;

import com.ekimtsovss.students_app.dao.StudentDaoImpl;
import com.ekimtsovss.students_app.entity.Student;
import com.ekimtsovss.students_app.service.ServiceStudent;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        return "initialPage";
    }
    @GetMapping("/application")
    public String application(Model model){
        System.out.println("application");
        Student student = new Student();
        model.addAttribute("student", student);
        return "student_application";
    }
    @PostMapping("/student")
//    public String saveStudent(@RequestParam int id,
//                              @RequestParam @Valid @ModelAttribute("student") String name,
//                              BindingResult bindingResult,
//                              @RequestParam String surname,
//                              @RequestParam long mobile) {
//        System.out.println(name+surname+mobile);
    public String saveStudent( @RequestBody @Valid @ModelAttribute("student") Student student,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "student_application";

        }
        else {

//            Student student = new Student();
//            student.setId(id);
//            student.setName(name);
//            student.setSurname(surname);
//            student.setMobile(mobile);

            if (student.getId() == 0)
                serviceStudent.saveStudent(student);
            else serviceStudent.updateStudent(student);
            System.out.println("!!!Q");

            return "redirect:/getAll";
        }
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
