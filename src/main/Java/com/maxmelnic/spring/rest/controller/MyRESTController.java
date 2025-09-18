package com.maxmelnic.spring.rest.controller;

import com.maxmelnic.spring.rest.entity.Employee;
import com.maxmelnic.spring.rest.exeption_handing.EmoloyeeIncorrectData;
import com.maxmelnic.spring.rest.exeption_handing.NoSuchEmployeeExeption;
import com.maxmelnic.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees;
    }
    @GetMapping("/employees/{id}")
    public Employee showEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null) {
            throw new NoSuchElementException("Employee with id " + id + " not found");
        }
        return employee;
    }

    @ExceptionHandler
    public ResponseEntity<EmoloyeeIncorrectData> handleException(NoSuchEmployeeExeption exeption) {
        EmoloyeeIncorrectData data = new EmoloyeeIncorrectData();
        data.setInfo(exeption.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<EmoloyeeIncorrectData> handleException(Exception exeption) {
        EmoloyeeIncorrectData data = new EmoloyeeIncorrectData();
        data.setInfo(exeption.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
