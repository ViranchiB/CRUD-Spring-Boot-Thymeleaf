package com.practice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
}
