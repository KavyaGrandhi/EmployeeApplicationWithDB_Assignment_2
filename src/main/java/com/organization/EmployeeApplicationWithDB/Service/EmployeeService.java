package com.organization.EmployeeApplicationWithDB.Service;

import com.organization.EmployeeApplicationWithDB.Entity.EmployeeEntity;
import com.organization.EmployeeApplicationWithDB.Model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee emp);

   List<Employee> fetchAllEmployees();

    Employee fetchEmployeeById(int id);

    String deleteEmployeeById(int id);

    Employee updateEmployeeById(Employee emp);
}
