package com.portal.employee.service;

import com.portal.employee.dao.EmployeeDao;
import com.portal.employee.dao.EmployeeDaoImpl;
import com.portal.employee.help.Helper;
import com.portal.employee.help.HelperConstants;
import com.portal.employee.model.Employee;
import com.portal.employee.vo.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{



    private EmployeeDao employeeDao;

    @Autowired
    @Qualifier("employeeDaoImpl")
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    private Employee employee;

    @Transactional
    @Override
    public void save(EmployeeVo employeeVo) {

            employee = new Employee();
            employee.setFirstName(employeeVo.getFirstName());
            employee.setLastName(employeeVo.getLastName());
            employee.setEmail(employeeVo.getEmail());
            employee.setSalary(employeeVo.getSalary());
            employee.setHireDate(employeeVo.getHireDate());
            employee.setAddress(employeeVo.getAddress());
            employee.setZipcode(employeeVo.getZipcode());
            employee.setPhoneNumber(employeeVo.getPhoneNumber());
            employee.setTitle(employeeVo.getTitle());
            employeeDao.save(employee);

    }

    @Transactional
    @Override
    public List<EmployeeVo> getAllEmployeesList() {
        List<EmployeeVo> empVoList;
        try {
            empVoList= Helper.copyToEmpVoList(employeeDao.getAllEmployees());
        }catch(Exception e){
            empVoList= new ArrayList<EmployeeVo>();
        }
        return empVoList;
    }

    @Transactional
    @Override
    public EmployeeVo getEmployeeData(Long id) {
        EmployeeVo empVo;
        try {
            empVo= Helper.copyToEmpVo(employeeDao.getEmployeeDetails(id));
        }catch(Exception e){
            empVo= new EmployeeVo();
        }
        return empVo;
    }

    @Transactional
    @Override
    public List<EmployeeVo> sortBy(String sortBy, String sortOrder) {
        List<Employee> empList=null;
        List<EmployeeVo> empVo=null;

        try {

            if (HelperConstants.SORTBY_FIRSTNAME.equals(sortBy)) {
                empList = employeeDao.getAllEmployees().stream()
                        .sorted(Comparator.comparing(Employee::getFirstName)) // sort by FirstName
                        .collect(Collectors.toList());
            } else if (HelperConstants.SORTBY_HIREDATE.equals(sortBy)) {
                empList = employeeDao.getAllEmployees().stream()
                        .sorted(Comparator.comparing(Employee::getHireDate)) // sort by FirstName
                        .collect(Collectors.toList());
            } else if (HelperConstants.SORTBY_SALARY.equals(sortBy)) {
                empList = employeeDao.getAllEmployees().stream()
                        .sorted(Comparator.comparing(Employee::getSalary)) // sort by FirstName
                        .collect(Collectors.toList());
            }

            if (HelperConstants.SORT_ORDER.equals(sortOrder)) Collections.reverse(empList);
             empVo=Helper.copyToEmpVoList(empList);

        }catch(Exception e){
            empVo= new ArrayList<EmployeeVo>();
        }

        return empVo;
    }
}
