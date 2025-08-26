package com.customer.service.section16.request;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequest {
    private String studentName;
    private String email;
    private Set<Long> courseIds;
}
