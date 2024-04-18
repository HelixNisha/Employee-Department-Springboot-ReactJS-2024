//package com.helix.ems.EmployeeMngmntSystem.controller;
//
//import com.helix.ems.EmployeeMngmntSystem.entity.Employee;
//import com.helix.ems.EmployeeMngmntSystem.service.EmployeeServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/api/employees")
//public class EmployHtmlController {
//
//    @Autowired
//    private EmployeeServiceImpl employeeService;
//
//    @PostMapping
//    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
//        Employee savedEmployee = employeeService.createEmployee(employee);
//        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId) {
//        Employee employee = employeeService.getEmployeeById(employeeId);
//        return ResponseEntity.ok(employee);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Employee>> getAllEmployees() {
//        List<Employee> employees = employeeService.getAllEmployees();
//        return ResponseEntity.ok(employees);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId,
//                                                   @RequestBody Employee updatedEmployee) {
//        Employee employee = employeeService.updateEmployee(employeeId, updatedEmployee);
//        return ResponseEntity.ok(employee);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
//        employeeService.deleteEmployee(employeeId);
//        return ResponseEntity.ok("Employee deleted successfully.");
//    }
//}
