package com.clear.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * ClassName FeignService
 *
 * @author qml
 * Date 2020/12/24 16:28
 * Version 1.0
 **/
@FeignClient("provider")
@CircuitBreaker(name = "backendA")
@RateLimiter(name = "backendA")
public interface FeignService extends HelloFacade{
}