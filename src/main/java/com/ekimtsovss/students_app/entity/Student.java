package com.ekimtsovss.students_app.entity;


import jakarta.annotation.Nonnull;

public class Student {
    private int id;

    private String name;
    private String surname;
    private long mobile;

    public Student() {
    }

    public Student(int id, String name, String surname, long mobile) {
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

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
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
