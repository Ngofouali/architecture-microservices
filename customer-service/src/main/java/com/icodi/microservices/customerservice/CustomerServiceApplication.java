package com.icodi.microservices.customerservice;

import com.icodi.microservices.customerservice.entities.Customer;
import com.icodi.microservices.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
        System.out.println("========================================");
        System.out.println(" Customer Service démarré !");
    }

}
