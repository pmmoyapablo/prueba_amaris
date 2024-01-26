package com.amaris.springboot.domain;

import org.assertj.core.util.Preconditions;
import java.io.Serializable;
import com.amaris.springboot.domain.entity.Data;

public class Employee implements Serializable{
    private String message;
    private String status;
    private Data data;

    public Employee()
    {}
    public Employee(Data data) {
        if(data == null)
            throw new NullPointerException("Objeto de tipo Data nu debe ser nulo");
        this.data = data;
        Preconditions.checkNotNullOrEmpty(data.employee_name, "Name can not be null or empity");
    }

    public int getId() {
        return data.id;
    }

    public String getName() {
        return data.employee_name;
    }

    public Double getSalary() {
        return data.employee_salary;
    }

    public int getAge() {
        return data.employee_age;
    }

    public String getImage() {
        return data.profile_image;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public Double getSalaryAnual()
    {
        return this.data.employee_salary * 12;
    }
}
