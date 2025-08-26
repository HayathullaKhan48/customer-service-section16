package com.customer.service.section16.service.impl;

import com.customer.service.section16.entity.CourseModel;
import com.customer.service.section16.repository.CourseRepository;
import com.customer.service.section16.request.CourseRequest;
import com.customer.service.section16.response.APIStudentResponse;
import com.customer.service.section16.response.CourseResponse;
import com.customer.service.section16.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public ResponseEntity<APIStudentResponse> registerCourse(CourseRequest request) {
        CourseModel course = CourseModel.builder()
                .courseName(request.getCourseName())
                .instructor(request.getInstructor())
                .build();

        CourseModel saved = courseRepository.save(course);

        return ResponseEntity.ok(new APIStudentResponse(200, "Course Registered",
                new CourseResponse(saved.getCourseName(), saved.getInstructor())));
    }

    @Override
    public ResponseEntity<APIStudentResponse> getAllCourse() {
        return ResponseEntity.ok(new APIStudentResponse(200, "Courses Retrieved", courseRepository.findAll()));
    }
}
