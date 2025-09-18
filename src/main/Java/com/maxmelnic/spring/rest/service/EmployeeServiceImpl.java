package com.maxmelnic.spring.rest.service;

import com.maxmelnic.spring.rest.dao.EmployeeDaoImp;
import com.maxmelnic.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements com.maxmelnic.spring.rest.service.EmployeeService {

    @Autowired
    private EmployeeDaoImp employeeDaoImp;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDaoImp.getAllEmployee();
    }

    @Override
    @Transactional
    public void saveEmp(Employee employee) {
        employeeDaoImp.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {

        return employeeDaoImp.getEmployeeById(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDaoImp.deleteEmployeeById(id);

    }
}