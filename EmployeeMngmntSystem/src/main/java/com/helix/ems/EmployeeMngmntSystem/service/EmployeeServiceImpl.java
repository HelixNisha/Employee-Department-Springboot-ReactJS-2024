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
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not Found for id:: " + employeeId);
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee updatedEmployee) {

        Optional<Employee> optional = repository.findById(employeeId);
        if (optional.isPresent()) {
            Employee existingEmployee = optional.get();
            // Update employee details
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
            existingEmployee.setLastName(updatedEmployee.getLastName());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            // Update department information
            existingEmployee.setDepartment(updatedEmployee.getDepartment());
            // Save the updated employee
            return repository.save(existingEmployee);
        } else {
            throw new RuntimeException("Employee not found for id: " + employeeId);
        }
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        this.repository.deleteById(employeeId);
    }
}
