package com.clear.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ClassName DirectReceiver
 *
 * @author qml
 * Date 2021/3/3 11:41
 * Version 1.0
 **/
@Component
public class DirectReceiver {
    @RabbitListener(queues = "hello-queue")
    public void handler(String message) {
        System.out.println(message);
    }
}