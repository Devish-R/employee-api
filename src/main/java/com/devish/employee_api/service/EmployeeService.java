package com.devish.employee_api.service;

import com.devish.employee_api.entity.Employee;
import com.devish.employee_api.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get Employee By ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // Create Employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Update Employee
    public Employee updateEmployee(Long id, Employee employee) {

        Employee existingEmployee = employeeRepository.findById(id).orElse(null);

        if (existingEmployee != null) {

            existingEmployee.setName(employee.getName());
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setSalary(employee.getSalary());

            return employeeRepository.save(existingEmployee);
        }

        return null;
    }

    // Delete Employee
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}