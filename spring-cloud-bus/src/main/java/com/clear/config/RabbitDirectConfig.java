package com.clear.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName RabbitDirectConfig
 *
 * @author qml
 * Date 2021/3/3 11:34
 * Version 1.0
 **/
@Configuration
public class RabbitDirectConfig {

    public final static String DIRECTNAME = "sang-direct";

    /**
     * 创建队列
     *
     * @param
     * @return org.springframework.amqp.core.Queue
     * @author qml
     * @date 2021/3/3 11:37
     **/
    @Bean
    Queue queue() {
        return new Queue("hello-queue");
    }


    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(DIRECTNAME,true,false);
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with("direct");
    }
}