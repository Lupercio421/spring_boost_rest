package com.example.payroll_maven;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
    }
}
