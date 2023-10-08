package com.example.students_journal.controller;

import com.example.students_journal.entity.Student;
import com.example.students_journal.entity.StudentData;
import com.example.students_journal.entity.StudentDelete;
import com.example.students_journal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/create-student")
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @PostMapping("/create-students")
    public List<Student> addStudents(@RequestBody List<Student> students) {
        return service.saveStudents(students);
    }

    @GetMapping("/get-students")
    public StudentData findAllStudents(
            @RequestParam(required = false) String studentName,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) String studentFrom,
            @RequestParam(required = false) String semester,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String faculty,
            @RequestParam(required = false) String assessment,
            @RequestParam(required = false) String educationStartYear,
            @RequestParam(required = false) String educationEndYear,
            @RequestParam(required = false) int page,
            @RequestParam(required = false) int count
    ) {
        return service.getStudents(
                studentName,
                lastname,
                studentFrom,
                semester,
                email,
                phone,
                gender,
                faculty,
                assessment,
                educationStartYear,
                educationEndYear,
                page,
                count
        );
    }

    @GetMapping("/get-student/{id}")
    public Student findStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @PutMapping("/update-student")
    public Student updateStudentById(@RequestBody Student student) {
        return service.updateStudent(student);
    }

    @DeleteMapping("/delete-student/{id}")
    public StudentDelete deleteStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }
}

