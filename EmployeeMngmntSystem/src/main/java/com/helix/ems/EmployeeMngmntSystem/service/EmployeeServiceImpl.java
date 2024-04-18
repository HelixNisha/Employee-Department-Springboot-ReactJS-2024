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


    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = repository.findById(id);
        return employeeOptional.orElse(null);
    }

    @Override
    public void saveEmployee(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        if (repository.existsById(id)) {
            employee.setId(id);
            repository.save(employee);
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
