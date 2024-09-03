package com.sudent_management.services;

import com.sudent_management.model.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    public Student getStudentById(Integer id);

    public Student saveStudent(Student student);

    public Student editStudent (Student student, Integer id);

    public String deleteStudent(Integer id);
}
