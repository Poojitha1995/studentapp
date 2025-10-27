package com.example.studentapp.controller;

import com.example.studentapp.model.Student;
import com.example.studentapp.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // POST → Add Student
    @PostMapping
    public String addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return "Student added successfully!";
    }

    // GET → Fetch all Students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
