package com.practice.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.Entity.Employee;
import com.practice.Repository.EmployeeRepository;

@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository;

    // aadd employee
    public Employee addEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    // Find all employee
    public List<Employee> findAllEmployee()
    {
        return employeeRepository.findAll();
    }

    // update employee
    public Employee updateEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    // delete employee by id
    public void deleteEmployeeById(int id)
    {
        employeeRepository.deleteById(id);
    }

    // find employee by id
    public Employee findEmployeeById(int id)
    {
        return employeeRepository.findById(id).get();
    }
}
