package com.example.PayRollService.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(int id) {
        super("Could not find this  id :"+id);
    }
}
