package com.customer.service.section16.service.impl;

import com.customer.service.section16.entity.CourseModel;
import com.customer.service.section16.entity.StudentModel;
import com.customer.service.section16.repository.CourseRepository;
import com.customer.service.section16.repository.StudentRepository;
import com.customer.service.section16.request.StudentRequest;
import com.customer.service.section16.response.APIStudentResponse;
import com.customer.service.section16.response.CourseResponse;
import com.customer.service.section16.response.StudentResponse;
import com.customer.service.section16.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public ResponseEntity<APIStudentResponse> registerStudent(StudentRequest request) {
        StudentModel student = StudentModel.builder()
                .studentName(request.getStudentName())
                .email(request.getEmail())
                .build();

        if (request.getCourseIds() != null) {
            Set<CourseModel> courses = courseRepository.findAllById(request.getCourseIds())
                    .stream().collect(Collectors.toSet());
            student.setCourses(courses);
        }

        StudentModel saved = studentRepository.save(student);

        StudentResponse response = StudentResponse.builder()
                .studentName(saved.getStudentName())
                .email(saved.getEmail())
                .courses(saved.getCourses().stream()
                        .map(c -> new CourseResponse(c.getCourseName(), c.getInstructor()))
                        .collect(Collectors.toSet()))
                .build();

        return ResponseEntity.ok(new APIStudentResponse(200, "Student Registered", response));
    }

    @Override
    public ResponseEntity<APIStudentResponse> getAllStudents() {
        return ResponseEntity.ok(
                new APIStudentResponse(200, "Data Retrieved", studentRepository.findAll()));
    }
}