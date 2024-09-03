package com.sudent_management.services;

import com.sudent_management.model.Student;
import com.sudent_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplement implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents () {
        return this.studentRepository.findAll();
    }

    @Override
    public Student getStudentById (Integer id) {
        return this.studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student saveStudent (Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public Student editStudent (Student student, Integer id) {
        Student previousStudentInfo = this.studentRepository.findById(id).orElse(null);

        if(previousStudentInfo != null) {
            previousStudentInfo.setStudentName(student.getStudentName());
            previousStudentInfo.setCity(student.getCity());
            previousStudentInfo.setStandard(student.getStandard());
            previousStudentInfo.setTeacherName(student.getTeacherName());

            return this.studentRepository.save(previousStudentInfo);
        }

        return null;
    }

    @Override
    public String deleteStudent (Integer id) {
        try {
            if(this.studentRepository.existsById(id)) {
                this.studentRepository.deleteById(id);
                return "success";
            }

            return null;
        } catch (Exception e) {
            return e.toString();
        }
    }
}
