package com.kubernetes.springkubernates.controller;

import com.kubernetes.springkubernates.Student;
import com.kubernetes.springkubernates.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // marks the class as a controller
@RequestMapping("/api/students") // Root path to the API endpoints in this class
public class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping // Get request that returns all students
    public ResponseEntity<List<Student>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}") // Get request that returns a specific student with the provided id
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        return new ResponseEntity<>(repository.findById(Long.valueOf(id))
                .orElseThrow(() -> new IllegalStateException("Student with id " + id + " not found")), HttpStatus.OK);
    }

    @PostMapping // Post request that creates a new student in the database
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(repository.save(student), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}") // Delete request that deletes a student in the database
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        repository.deleteById(Long.valueOf(id));
        return new ResponseEntity<>("Student deleted", HttpStatus.NO_CONTENT);
    }
}
