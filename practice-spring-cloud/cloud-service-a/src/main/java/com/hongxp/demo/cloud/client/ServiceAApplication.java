package com.hongxp.demo.cloud.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceAApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceAApplication.class)
                .web(true)
                .run(args);
    }
}
