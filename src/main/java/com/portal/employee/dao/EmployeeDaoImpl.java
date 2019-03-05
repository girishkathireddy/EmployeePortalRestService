package com.portal.employee.dao;

import com.portal.employee.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements  EmployeeDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> retList;
        try {
            TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee");
            retList= query.getResultList();
        }catch(Exception e){
            retList= new ArrayList<Employee>();
        }
        return retList;
    }

    @Override
    public Employee getEmployeeDetails(Long id) {
        Employee retEmp;
        try {
            TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee where id=:id");
            query.setParameter("id", id);
            retEmp= query.getSingleResult();
        }catch(Exception e){
            retEmp= new Employee();
        }
        return retEmp;
    }
}
