package com.ekimtsovss.students_app.entity;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.boot.context.properties.bind.DefaultValue;

public class Student {
    private int id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Surname is mandatory")
    private String surname;
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{2}",
            message = "Phone number must be xxx-xxx-xx")
     private String mobile;

    public Student() {
    }

    public Student(int id, String name, String surname, String mobile) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}
