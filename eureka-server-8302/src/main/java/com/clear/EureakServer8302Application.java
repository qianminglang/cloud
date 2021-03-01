package com.clear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EureakServer8302Application {

    public static void main(String[] args) {
        SpringApplication.run(EureakServer8302Application.class, args);
    }

}
