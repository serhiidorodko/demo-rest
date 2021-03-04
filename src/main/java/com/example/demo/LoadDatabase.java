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
    CommandLineRunner initDatabase(EmployeeRepository repository){
        return args -> {
            repository.save(new Employee("Serhii", "Dorodko", "assistant"));
            repository.save(new Employee("Kate", "Dorodko", "capitan"));
            log.info("Preloaded records: \n" + repository.findAll().toString());
            
        };
    }
}