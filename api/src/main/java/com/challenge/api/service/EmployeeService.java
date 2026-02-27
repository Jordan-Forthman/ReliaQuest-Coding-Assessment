package com.challenge.api.service;

import com.challenge.api.model.Employee;
import java.util.List;
import java.util.UUID;

/**
 * Service interface for managing Employee data.
 * This layer handles the business logic and data retrieval.
 */
public interface EmployeeService {

    /**
     * Retrieves all employees from the system.
     * @return a list of all Employees.
     */
    List<Employee> getAllEmployees();

    /**
     * Finds a specific employee by their unique identifier.
     * @param uuid the unique identifier of the employee.
     * @return the Employee if found, or null/exception if not.
     */
    Employee getEmployeeByUuid(UUID uuid);

    /**
     * Creates a new employee record.
     * @param employeeData the employee object to be created.
     * @return the newly created Employee.
     */
    Employee createEmployee(Employee employeeData);
}
