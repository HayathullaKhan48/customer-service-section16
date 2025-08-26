package com.customer.service.section16.exceptions;

/**
 * Customer exception for the case when a customer already exists in the system
 */
public class CustomerAlreadyExistsException extends RuntimeException {
    public CustomerAlreadyExistsException() {
    }

    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
