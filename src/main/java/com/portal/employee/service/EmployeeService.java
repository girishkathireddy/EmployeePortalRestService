package com.portal.employee.service;

import com.portal.employee.model.Employee;
import com.portal.employee.vo.EmployeeVo;

import java.util.List;

public interface EmployeeService {

    public void save(EmployeeVo employeeVo);
    public List<EmployeeVo> getAllEmployeesList();
    public EmployeeVo getEmployeeData(Long id);
    public List<EmployeeVo> sortBy(String sortBy, String sortOrder);
}
