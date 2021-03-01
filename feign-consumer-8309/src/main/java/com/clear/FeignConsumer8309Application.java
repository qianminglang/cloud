package com.clear;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableFeignClients
public class FeignConsumer8309Application {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumer8309Application.class, args);
    }

    /**
     * 使用了 Feign 之后，如果希望能够查看微服务之间调用的日志，则可以通过开启 Feign 的日志功能实现， Feign 中的日志级别一共分为四种：
     * NONE ，不开启日志记录，默认即此；
     * BASIC ，记录请求方法和请求 URL ，以及响应的状态码以及执行时间；
     * HEADERS ，在第2条的基础上，再增加请求头和响应头；
     * FULL ，在第3条的基础上再增加 body 以及元数据。
     **/
    @Bean
    Logger.Level level() {
        return Logger.Level.FULL;
    }

//    @Bean
//    public Retryer feignRetryer() {
//        Retryer.Default retryer = new Retryer.Default();
//        return retryer;
//    }
}
