package com.clear.controller;

import com.clear.service.FeignService;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.vavr.control.Try;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Duration;

/**
 * ClassName HelloController
 *
 * @author qml
 * Date 2020/12/24 11:40
 * Version 1.0
 **/
@RestController
public class HelloRest {
    @Resource
    FeignService feignService;

    @GetMapping("/hello")
    public String hello(String name) {
//        String hello = feignService.hello(name);
//        return hello;

//        RetryConfig retryConfig = RetryConfig.custom()
//                .maxAttempts(3)
//                .waitDuration(Duration.ofMillis(5000))
//                .build();
//        Retry retry = Retry.of("id", retryConfig);
//        Try<String> result = Try.ofSupplier(Retry.decorateSupplier(retry, () -> feignService.hello(name)));
//        return result.get();



        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(1000))
                .ringBufferSizeInHalfOpenState(20)
                .ringBufferSizeInClosedState(20)
                .build();
        CircuitBreaker circuitBreaker = CircuitBreaker.of("backendA", circuitBreakerConfig);
        Try<String> supplier = Try.ofSupplier(io.github.resilience4j.circuitbreaker.CircuitBreaker
                .decorateSupplier(circuitBreaker,
                        () ->feignService.hello(name)))
                .recover(Exception.class, "有异常，访问失败!");
        return supplier.get();
    }

    @GetMapping("rl")
    public void rateLimiter(String name){
        for (int i = 0; i < 10; i++) {
            feignService.hello(name);
        }
    }
}