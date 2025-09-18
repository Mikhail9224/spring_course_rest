package com.maxmelnic.spring.rest.dao;

import com.maxmelnic.spring.rest.entity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class EmployeeDaoImp implements EmployeeDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = sessionFactory.getCurrentSession().createQuery("from Employee"
                ,Employee.class).getResultList();
        return employees;
    }

    @Override
    public void saveEmployee(Employee employee) {
       sessionFactory.getCurrentSession().saveOrUpdate(employee);

    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = sessionFactory.getCurrentSession().get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployeeById(int id) {
        Query queue = sessionFactory.getCurrentSession().createQuery("delete from Employee " +
                "where id =:employID");
        queue.setParameter("employID", id);
        queue.executeUpdate();
    }
}