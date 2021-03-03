package com.clear.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ClassName RabbitProperties
 *
 * @author qml
 * Date 2021/3/3 11:16
 * Version 1.0
 **/
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitProperties {
    private String host = "localhost";
    private int port = 5672;
    private String username = "guest";
    private String password = "guest";
}