package com.organization.EmployeeApplicationWithDB.Service;

import com.organization.EmployeeApplicationWithDB.Entity.EmployeeEntity;
import com.organization.EmployeeApplicationWithDB.Model.Employee;
import com.organization.EmployeeApplicationWithDB.Repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee emp) {
        EmployeeEntity employeeEntity=new EmployeeEntity();
        BeanUtils.copyProperties(emp,employeeEntity);
        employeeRepository.save(employeeEntity);
        return emp;
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        List<EmployeeEntity> employeeEntities= employeeRepository.findAll();
        List<Employee> employees=employeeEntities.stream().map(employeeEntity-> {
            Employee emp=new Employee();
            BeanUtils.copyProperties(employeeEntity,emp);
            return emp ;
        }).collect(Collectors.toList());
        return employees;
    }

    @Override
    public Employee fetchEmployeeById(int id) {
       EmployeeEntity e=employeeRepository.findById(id).get();
      Employee employee=new Employee();
      BeanUtils.copyProperties(e,employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
        return "Employee with id "+id+" removed successfully";
    }

    @Override
    public Employee updateEmployeeById(Employee emp) {
        EmployeeEntity e=employeeRepository.findById(emp.getId()).get();
        e.setId(emp.getId());
        e.setName(emp.getName());
        e.setDepartmentName(emp.getDepartmentName());
        e.setEmailId(emp.getEmailId());
        e.setSalary(emp.getSalary());
        employeeRepository.save(e);
        return emp;
    }
}
