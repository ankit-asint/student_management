package com.sudent_management.controller;

import com.sudent_management.model.Student;
import com.sudent_management.services.StudentServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentServiceImplement studentServiceImplement;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> fetchAllStudents () {
        try {
            List<Student> studentsList = this.studentServiceImplement.getAllStudents();

            return new ResponseEntity<>(studentsList, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> fetchSingleStudent (@PathVariable("id") Integer id) {
        try {
            Student singleStudentInfo = this.studentServiceImplement.getStudentById(id);

            if(singleStudentInfo != null) {
                return new ResponseEntity<>(singleStudentInfo, HttpStatus.OK);
            }

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Student with ID " + id + " was not found.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping("/student/save")
    public ResponseEntity<Student> addStudent (@RequestBody Student student) {
        try {
            Student savedStudent = this.studentServiceImplement.saveStudent(student);

            return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("student/update/{id}")
    public ResponseEntity<?> updateStudentInfo (@RequestBody Student student, @PathVariable("id") Integer id) {
        try {
            Student result = this.studentServiceImplement.editStudent(student, id);

            if (result != null) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Student with ID " + id + " was not found.");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while updating the student information.");
        }
    }

    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<String> removeStudent (@PathVariable("id") Integer id) {
        try {
            String result = this.studentServiceImplement.deleteStudent(id);

            if(result != null) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            }

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Student with ID " + id + " was not found.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
