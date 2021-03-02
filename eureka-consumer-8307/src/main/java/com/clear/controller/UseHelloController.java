package com.clear.controller;

import com.clear.service.HelloService;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.vavr.control.Try;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.Duration;

/**
 * ClassName UseHelloController
 *
 * @author qml
 * Date 2020/12/23 11:50
 * Version 1.0
 **/
@RestController
//@Retry(name = "retryBackendA")
public class UseHelloController {
    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HelloService helloService;


    int count = 0;

    @GetMapping("/hello")
    public String hello(String name) {
//        List<ServiceInstance> providers = discoveryClient.getInstances("provider");
//        ServiceInstance serviceInstance = providers.get(count % providers.size());
//        count++;
//        String host = serviceInstance.getHost();
//        int port = serviceInstance.getPort();FeignService
//        String result = restTemplate.getForObject("http://" + host + ":" + port + "/hello?name={1}", String.class, name);

//        String result = restTemplate.getForObject("http://provider/hello?name={1}", String.class, name);
//        return result;
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofMillis(5000))
                .build();

        Retry retry = Retry.of("id", config);
        Try<String> result = Try.ofSupplier(Retry.decorateSupplier(retry, () -> helloService.hello(name)));
        return result.get();
    }

    @GetMapping("/foo")
    public String foo(String foo) {
        return helloService.foo(foo);
    }
}