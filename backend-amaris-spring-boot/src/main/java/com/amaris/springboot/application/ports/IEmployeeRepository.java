package com.amaris.springboot.application.ports;

import com.amaris.springboot.domain.Employee;
import java.util.List;

public interface IEmployeeRepository {
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();

}
