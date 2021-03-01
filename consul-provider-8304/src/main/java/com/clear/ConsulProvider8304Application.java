package com.clear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulProvider8304Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsulProvider8304Application.class, args);
    }

}
