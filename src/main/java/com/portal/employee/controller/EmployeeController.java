package com.portal.employee.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.portal.employee.dao.EmployeeDao;
import com.portal.employee.model.Employee;
import com.portal.employee.service.EmployeeService;
import com.portal.employee.service.EmployeeServiceImpl;
import com.portal.employee.vo.EmployeeVo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800, allowCredentials = "false")
@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(@Qualifier("employeeServiceImpl") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployee(@RequestBody EmployeeVo employeeVo){
        String ret;
        try {
            employeeService.save(employeeVo);
            ret= "Data saved";
        }catch(Exception e){
            ret="Error while saving the data";
        }
        return JSONObject.quote(ret);
    }

    @RequestMapping(value="/getAll", method=RequestMethod.GET)
    public List<EmployeeVo> getAllEmployee(){
        List<EmployeeVo> voList;
        try {
            voList= employeeService.getAllEmployeesList();
        }catch(Exception e){
            voList= new ArrayList<EmployeeVo>();
        }
        return  voList;
    }

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public EmployeeVo getEmployee(@PathVariable("id") Long id){
        EmployeeVo  empVo;
        try {
            empVo= employeeService.getEmployeeData(id);
        }catch(Exception e){
            empVo= new EmployeeVo();
        }
        return  empVo;
    }

    @RequestMapping(value="/filter", method=RequestMethod.GET)
    public List<EmployeeVo> sortBy(@RequestParam("sortBy")String sortBy,@RequestParam(value = "sort", required = false) String sortOrder){
      List<EmployeeVo> empVoList;
      try {
          empVoList= employeeService.sortBy(sortBy, sortOrder);
      }catch(Exception e){
          empVoList=new ArrayList<EmployeeVo>();
      }
       return empVoList;
    }
}
