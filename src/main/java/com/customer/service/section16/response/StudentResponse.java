package com.customer.service.section16.response;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse {
    private String studentName;
    private String email;
    private Set<CourseResponse> courses;
}
