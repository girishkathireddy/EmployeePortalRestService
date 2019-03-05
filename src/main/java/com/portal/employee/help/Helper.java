package com.portal.employee.help;

import com.portal.employee.model.Employee;
import com.portal.employee.vo.EmployeeVo;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    public static EmployeeVo copyToEmpVo(Employee emp){
        EmployeeVo employeeVo= new EmployeeVo();
            employeeVo.setId(emp.getId());
            employeeVo.setFirstName(StringUtils.defaultString(emp.getFirstName()));
            employeeVo.setLastName(StringUtils.defaultString(emp.getLastName()));
            employeeVo.setEmail(StringUtils.defaultString(emp.getEmail()));
            employeeVo.setSalary(emp.getSalary());
            employeeVo.setHireDate(emp.getHireDate());
            employeeVo.setAddress(StringUtils.defaultString(emp.getAddress()));
            employeeVo.setZipcode(StringUtils.defaultString(emp.getZipcode()));
            employeeVo.setPhoneNumber(StringUtils.defaultString(emp.getPhoneNumber()));
            employeeVo.setTitle(StringUtils.defaultString(emp.getTitle()));

        return employeeVo;
    }

    public static List<EmployeeVo> copyToEmpVoList(List<Employee> list){
        List<EmployeeVo> voList= new ArrayList<EmployeeVo>();
        for (Employee emp: list) {
            voList.add(copyToEmpVo(emp));
        }
        return voList;
    }
}
