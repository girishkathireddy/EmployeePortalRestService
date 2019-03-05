package com.portal.employee.dao;

import com.portal.employee.model.Employee;

import java.util.List;


public interface EmployeeDao {
    public void save(Employee employee);
    public List<Employee> getAllEmployees();
    public Employee getEmployeeDetails(Long id);
}
