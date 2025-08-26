package com.customer.service.section16.controller;

import com.customer.service.section16.request.StudentRequest;
import com.customer.service.section16.response.APIStudentResponse;
import com.customer.service.section16.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public ResponseEntity<APIStudentResponse> register(@RequestBody StudentRequest request) {
        return studentService.registerStudent(request);
    }

    @GetMapping("/getAllData")
    public ResponseEntity<APIStudentResponse> getAll() {
        return studentService.getAllStudents();
    }
}