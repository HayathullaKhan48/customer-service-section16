package com.customer.service.section16.service;

import com.customer.service.section16.request.CourseRequest;
import com.customer.service.section16.request.StudentRequest;
import com.customer.service.section16.response.APIStudentResponse;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    ResponseEntity<APIStudentResponse> registerStudent(StudentRequest request);
    ResponseEntity<APIStudentResponse> getAllStudents();
}
