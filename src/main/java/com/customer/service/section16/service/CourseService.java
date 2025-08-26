package com.customer.service.section16.service;

import com.customer.service.section16.request.CourseRequest;
import com.customer.service.section16.response.APIStudentResponse;
import org.springframework.http.ResponseEntity;

public interface CourseService {
    ResponseEntity<APIStudentResponse> registerCourse(CourseRequest request);
    ResponseEntity<APIStudentResponse> getAllCourse();
}
