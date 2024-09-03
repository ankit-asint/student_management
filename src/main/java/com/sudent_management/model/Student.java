package com.sudent_management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Integer id;

    private String studentName;

    @Column(name = "student_class")
    private String standard;

    private String city;

    private String teacherName;

    // default constructor
    public Student () {
        super();
    }
    public Student (Integer id, String studentName, String standard, String city, String teacherName) {
        super();
        this.id = id;
        this.studentName = studentName;
        this.standard = standard;
        this.city = city;
        this.teacherName = teacherName;
    }

    // getters and setters
    // id
    public Integer getId () {
        return this.id;
    }
    public void setId (Integer id) {
        this.id = id;
    }

    // student name
    public String getStudentName () {
        return this.studentName;
    }
    public void setStudentName (String studentName) {
        this.studentName = studentName;
    }

    // standard
    public String getStandard () {
        return this.standard;
    }
    public void setStandard (String standard) {
        this.standard = standard;
    }

    // city
    public String getCity () {
        return this.city;
    }
    public void setCity (String city) {
        this.city = city;
    }

    //teacher name
    public String getTeacherName () {
        return this.teacherName;
    }
    public void setTeacherName (String teacherName) {
        this.teacherName = teacherName;
    }
}
