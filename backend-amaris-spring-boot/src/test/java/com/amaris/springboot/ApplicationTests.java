package com.amaris.springboot;

import com.amaris.springboot.domain.entity.Data;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.amaris.springboot.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	@DisplayName("It should not set Name for invalid case")
	void testNameEmployeNullEmpity() {
		//Arrange
		var data1 = new Data();
		data1.id = 1;
		data1.employee_age = 32;
		data1.employee_salary = 2000.00;
		data1.employee_name = null;
		data1.profile_image = ".../";

		var data2 = new Data();
		data2.id = 2;
		data2.employee_age = 35;
		data2.employee_salary = 3000.00;
		data2.employee_name = "";
		data2.profile_image = ".../";

		//Act y Asert
		assertAll(
				() -> assertThrows(NullPointerException.class, () -> new Employee(data1)),
				() -> assertThrows(IllegalArgumentException.class, () -> new Employee(data2))
		);
	}

	@Test
	@DisplayName("It should not set Name for invalid case")
	void testDataEmployeNull() {
		//Arrange
		Data data = null;

		//Act y Asert
		assertAll(
				() -> assertThrows(NullPointerException.class, () -> new Employee(data))
		);
	}

	@Test
	@DisplayName("It should get the value salary_anual")
	void testSalaryAnualEmploye(){
		//Arrange
		var data = new Data();
		data.id = 1;
		data.employee_age = 32;
		data.employee_salary = 2000.00;
		data.employee_name = "Pepe Mendez";
		data.profile_image = ".../";
		var employee = new Employee(data);
		var salary_expected = 24000.00;
		//Act
		Double salary_result = employee.getSalaryAnual();
		//Assert
		assertEquals(salary_expected, salary_result);
	}
}
