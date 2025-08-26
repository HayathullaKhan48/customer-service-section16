package com.customer.service.section16.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APIStudentResponse {
    private int errorCode;
    private String errorMessage;
    private Object data;
}
