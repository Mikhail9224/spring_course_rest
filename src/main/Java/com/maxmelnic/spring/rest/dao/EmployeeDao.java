package com.maxmelnic.spring.rest.dao;

import com.maxmelnic.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getAllEmployee();

      public void saveEmployee(Employee employee);

      public Employee getEmployeeById(int id);

      public void deleteEmployeeById(int id);

}