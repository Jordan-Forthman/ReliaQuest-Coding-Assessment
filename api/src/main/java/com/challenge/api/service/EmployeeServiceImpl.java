package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * Implementation of the EmployeeService interface.
 * Handles the logic for managing the mock employee data.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    // In-memory data store for Employees. Effectively the mock "database".
    private final List<Employee> employees = new ArrayList<>();

    public EmployeeServiceImpl() {
        // Seeding
        Employee emp1 = new EmployeeImpl();
        emp1.setUuid(UUID.randomUUID());
        emp1.setFirstName("Jordan");
        emp1.setLastName("Forthman");
        emp1.setFullName("Jordan Forthman");
        emp1.setSalary(80000);
        emp1.setAge(26);
        emp1.setJobTitle("Software Engineer");
        emp1.setEmail("jordanforthman@yahoo.com");

        Employee emp2 = new EmployeeImpl();
        emp2.setUuid(UUID.randomUUID());
        emp2.setFirstName("Mike");
        emp2.setLastName("Forthman");
        emp2.setFullName("Mike Forthman");
        emp2.setSalary(100000);
        emp2.setAge(64);
        emp2.setJobTitle("Senior Developer");
        emp2.setEmail("mikeforthman@yahoo.com");

        employees.add(emp1);
        employees.add(emp2);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeByUuid(UUID uuid) {
        return employees.stream()
                .filter(employee -> employee.getUuid().equals(uuid))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Employee createEmployee(Employee employeeData) {
        // Ensure new employee has a UUID before saving
        if (employeeData.getUuid() == null) {
            employeeData.setUuid(UUID.randomUUID());
        }

        // Auto-populate full name if not provided, using first and last names.
        if (employeeData.getFullName() == null) {
            employeeData.setFullName(employeeData.getFirstName() + " " + employeeData.getLastName());
        }

        employees.add(employeeData);
        return employeeData;
    }
}
