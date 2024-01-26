package com.amaris.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  com.amaris.springboot.application.*;
import  com.amaris.springboot.application.dtos.EmployeeDto;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final ServiceApplication serviceApplication;
    public EmployeeController(ServiceApplication serviceApplication){
        this.serviceApplication = serviceApplication;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("")
    ResponseEntity<Response<List<EmployeeDto>>> getAll() {
        var response = serviceApplication.getAllEmployees();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    ResponseEntity<Response<EmployeeDto>> getOne(@PathVariable int id) {
        var response = serviceApplication.getEmployeeById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
