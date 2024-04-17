package com.helix.ems.EmployeeMngmntSystem.service;

import com.helix.ems.EmployeeMngmntSystem.entity.Department;
import com.helix.ems.EmployeeMngmntSystem.entity.Employee;
import com.helix.ems.EmployeeMngmntSystem.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department createDepartment(Department department) {
        Department savedDepartment = departmentRepository.save(department);
        // Return the saved employee
        return savedDepartment;
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        Optional<Department> optional = departmentRepository.findById(departmentId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Department not found for id: " + departmentId);
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Long departmentId, Department updatedDepartment) {
        Optional<Department> optional = departmentRepository.findById(departmentId);
        if (optional.isPresent()) {
            Department existingDepartment = optional.get();
            existingDepartment.setDepartmentName(updatedDepartment.getDepartmentName());
            existingDepartment.setDepartmentDescription(updatedDepartment.getDepartmentDescription());
            // You might want to update employees list if necessary
            // existingDepartment.setEmployees(updatedDepartment.getEmployees());
            return departmentRepository.save(existingDepartment);
        } else {
            throw new RuntimeException("Department not found for id: " + departmentId);
        }
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
