package com.clear.config;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;
import org.junit.Test;

/**
 * ClassName CircuitBreaker
 *
 * @author qml
 * Date 2021/1/12 15:11
 * Version 1.0
 **/
public class CircuitBreakerTest {
    @Test
    public void circuit(){
//        CircuitBreakerConfig breakerConfig = CircuitBreakerConfig.custom()
//                .failureRateThreshold(50)
//                .waitDurationInOpenState(Duration.ofMillis(1000))
//                .ringBufferSizeInHalfOpenState(2)
//                .ringBufferSizeInClosedState(2)
//                .build();
//
//        CircuitBreakerRegistry.of(breakerConfig);

        CircuitBreaker testName = CircuitBreaker.ofDefaults("testName");
        CheckedFunction0<String> decorateCheckedSupplier = CircuitBreaker.decorateCheckedSupplier(testName, () -> "This can be any method which returns: 'Hello'");
        Try<String> result = Try.of(decorateCheckedSupplier).map(value -> value + "world");
        System.out.println(result.isSuccess());
        System.out.println(result.get());
    }
}