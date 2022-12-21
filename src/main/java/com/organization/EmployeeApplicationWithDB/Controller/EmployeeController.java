package com.organization.EmployeeApplicationWithDB.Controller;

import com.organization.EmployeeApplicationWithDB.Model.Employee;
import com.organization.EmployeeApplicationWithDB.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee emp){
        return employeeService.saveEmployee(emp);
    }
    @GetMapping
    public List<Employee> fetchAllEmployees(){
        return employeeService.fetchAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee fetchEmployeeById(@PathVariable int id){
        return employeeService.fetchEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployeeById(@RequestBody Employee emp){
        return employeeService.updateEmployeeById(emp);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable int id){
        return employeeService.deleteEmployeeById(id);
    }

}
