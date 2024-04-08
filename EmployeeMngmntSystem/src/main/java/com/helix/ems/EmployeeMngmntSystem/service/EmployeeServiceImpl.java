package com.helix.ems.EmployeeMngmntSystem.service;

import com.helix.ems.EmployeeMngmntSystem.entity.Employee;
import com.helix.ems.EmployeeMngmntSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Employee savedEmployee = repository.save(employee);
        // Return the saved employee
        return savedEmployee;
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        Optional<Employee> optional = repository.findById(employeeId);
        Employee student = null;
        if (optional.isPresent()) {
            student = optional.get();
        } else {
            throw new RuntimeException("Student not Found for id:: " + employeeId);
        }
        return student;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee updatedEmployee) {
        return null;
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        this.repository.deleteById(employeeId);
    }
}
