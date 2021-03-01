package com.clear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsuleProvider8303Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsuleProvider8303Application.class, args);
    }

}
