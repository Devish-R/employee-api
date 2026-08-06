package com.devish.employee_api.config;

import com.devish.employee_api.entity.Employee;
import com.devish.employee_api.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(EmployeeRepository repository) {

        return args -> {

            repository.save(new Employee(null, "Devish", "DevOps", 50000));
            repository.save(new Employee(null, "Rahul", "Cloud", 60000));
            repository.save(new Employee(null, "Priya", "Testing", 45000));
            repository.save(new Employee(null, "Arun", "Development", 70000));
            repository.save(new Employee(null, "Rahul", "Cloud Engineer", 65000));
            repository.save(new Employee(null, "kishore", "Dataanalyst", 50000));
            repository.save(new Employee(null, "Lokesh", "ITSupport", 25000));
        };
    }
}