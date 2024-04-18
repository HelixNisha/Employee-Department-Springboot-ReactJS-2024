package com.helix.ems.EmployeeMngmntSystem.service;

import com.helix.ems.EmployeeMngmntSystem.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    void saveEmployee(Employee employee);

    void updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

}
