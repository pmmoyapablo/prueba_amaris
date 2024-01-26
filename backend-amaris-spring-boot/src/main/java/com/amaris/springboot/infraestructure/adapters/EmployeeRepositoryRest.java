package com.amaris.springboot.infraestructure.adapters;

import com.amaris.springboot.application.ports.IEmployeeRepository;
import com.amaris.springboot.domain.Employee;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.amaris.springboot.domain.entity.Data;
import com.amaris.springboot.domain.entity.ListEmployees;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryRest implements IEmployeeRepository {
    @Override
    public Employee getEmployeeById(int id) {
            Client cliente = ClientBuilder.newClient();
            Employee employee =  cliente.target("https://dummy.restapiexample.com/api/v1/employee/" + String.valueOf(id)).request(MediaType.APPLICATION_JSON_TYPE).get(Employee.class);;
            return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
            Client cliente = ClientBuilder.newClient();
            List<Employee> employees = new ArrayList<Employee>();
            ListEmployees employeeList =  cliente.target("https://dummy.restapiexample.com/api/v1/employees").request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<ListEmployees>(){});

            for(Data data : employeeList.getData())
            {
                var employee = new Employee(data);
                employees.add(employee);
            }

            return employees;
    }
}
