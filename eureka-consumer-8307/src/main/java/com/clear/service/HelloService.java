package com.clear.service;

import org.springframework.cloud.openfeign.FeignClient;



/**
 * @Author 江南一点雨
 * @Date 2019/4/8 20:08
 */
@FeignClient("provider")
public interface HelloService extends HelloFacade {

}
