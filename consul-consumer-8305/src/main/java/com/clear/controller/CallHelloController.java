package com.clear.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * ClassName CallHelloController
 *
 * @author qml
 * Date 2020/12/23 10:16
 * Version 1.0
 **/
@RestController
@Slf4j
public class CallHelloController {
    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/call")
    public String call() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("consul-provider");
        log.info("服务地址:" + serviceInstance.getUri());
        log.info("服务名称:" + serviceInstance.getServiceId());

        String result = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/hello", String.class);
        log.info("调用结果：" + result);
        return result;
    }
}