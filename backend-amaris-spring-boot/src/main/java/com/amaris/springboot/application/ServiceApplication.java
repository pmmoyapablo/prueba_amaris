package com.amaris.springboot.application;

import com.amaris.springboot.domain.Employee;
import com.amaris.springboot.application.dtos.EmployeeDto;
import com.amaris.springboot.application.ports.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceApplication {
    private final IEmployeeRepository iEmployeeRepository;
    private final ILoggerApplication iLoggerApplication;
    public ServiceApplication(IEmployeeRepository iEmployeeRepository, ILoggerApplication iLoggerApplication)
    {
        this.iEmployeeRepository = iEmployeeRepository;
        this.iLoggerApplication = iLoggerApplication;
    }
    //HU-1 Obtener los datos de un empleado por Id con su salario anual
    public Response<EmployeeDto> getEmployeeById(int id)
    {
        Response<EmployeeDto> response = new Response<EmployeeDto>();
        try{
            Employee employee = iEmployeeRepository.getEmployeeById(id);
            //Mapeo a Dto
            EmployeeDto dto = new EmployeeDto();
            dto.id = employee.getId();
            dto.name = employee.getName();
            dto.age = employee.getAge();
            dto.salary = employee.getSalary();
            dto.salaryAnual = employee.getSalaryAnual();
            dto.image = employee.getImage();

            response.Data = dto;
            response.IsSuccess = true;
            response.Messange = "Consulta Exitosa!!!";

            iLoggerApplication.LogInformation(response.Messange);

        }catch(Exception ex)
        {
            response.IsSuccess = false;
            response.Messange = "Error al intentar consultar objeto";
            iLoggerApplication.LogError(ex.getMessage());
        }

        return response;
    }
    //HU-2 Listar todos los empleados con su salario anual
    public Response<List<EmployeeDto>> getAllEmployees()
    {
        Response<List<EmployeeDto>> response = new Response<List<EmployeeDto>>();
        try{
            List<Employee> employees = iEmployeeRepository.getAllEmployees();
            List<EmployeeDto> dtos = new ArrayList<>();

            for(Employee employee : employees)
            {
                EmployeeDto dto = new EmployeeDto();
                dto.id = employee.getId();
                dto.name = employee.getName();
                dto.age = employee.getAge();
                dto.salary = employee.getSalary();
                dto.salaryAnual = employee.getSalaryAnual();
                dto.image = employee.getImage();

                dtos.add(dto);
            }

            response.Data = dtos;
            response.IsSuccess = true;
            response.Messange = "Consulta Exitosa!!!";

            iLoggerApplication.LogInformation(response.Messange);

        }catch(Exception ex)
        {
            response.IsSuccess = false;
            response.Messange = "Error al intentar consultar lista";
            iLoggerApplication.LogError(ex.getMessage());
        }
        return response;
    }
}
