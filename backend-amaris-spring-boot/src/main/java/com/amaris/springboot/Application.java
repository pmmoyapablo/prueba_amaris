package com.amaris.springboot;

import com.amaris.springboot.application.ServiceApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.amaris.springboot.application.ports.*;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private IEmployeeRepository iEmployeeRepository;
    private ILoggerApplication loggerApplication;
    private ServiceApplication serviceApplication;

    public Application(
            IEmployeeRepository iEmployeeRepository,
            ILoggerApplication loggerApplication,
            ServiceApplication serviceApplication
            ) {
        this.iEmployeeRepository = iEmployeeRepository;
        this.loggerApplication = loggerApplication;
        this.serviceApplication = serviceApplication;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Bienvenido a Sprint Boot");
    }

}
