package com.maxmelnic.spring.rest.service;

import com.maxmelnic.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public void saveEmp(Employee employee);
    public Employee getEmployeeById(int id);
    public void deleteEmployee(int id);

}