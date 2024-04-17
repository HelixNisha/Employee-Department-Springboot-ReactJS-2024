package com.helix.ems.EmployeeMngmntSystem.service;

import com.helix.ems.EmployeeMngmntSystem.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department createDepartment(Department department);

    Department getDepartmentById(Long departmentId);

    List<Department> getAllDepartments();

    Department updateDepartment(Long departmentId, Department updatedDepartment);

    void deleteDepartment(Long departmentId);

}
