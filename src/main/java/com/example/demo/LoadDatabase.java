package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepo, OrderRepository orderRepo){
        return args -> {
            employeeRepo.save(new Employee("Serhii", "Dorodko", "assistant"));
            employeeRepo.save(new Employee("Kate", "Dorodko", "capitan"));
            log.info("Preloaded records in Employee repository: \n" + employeeRepo.findAll().toString());

            orderRepo.save(new Order("Description 1", Status.COMPLETED));
            log.info("Preloaded records in Order repository: \n" + orderRepo.findAll().toString());
            
        };
    }
}