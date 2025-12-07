package com.icodi.microservices.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableDiscoveryClient
public class GatewayServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(GatewayServiceApplication.class, args);
        System.out.println("======================================");
        System.out.println("API Gateway démarré !");
        System.out.println("======================================");
    }

}
