package com.customer.service.section16.controller;

import com.customer.service.section16.request.CourseRequest;
import com.customer.service.section16.response.APIStudentResponse;
import com.customer.service.section16.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/register")
    public ResponseEntity<APIStudentResponse> register(@RequestBody CourseRequest request) {
        return courseService.registerCourse(request);
    }

    @GetMapping("/getAllData")
    public ResponseEntity<APIStudentResponse> getAll() {
        return courseService.getAllCourse();
    }
}