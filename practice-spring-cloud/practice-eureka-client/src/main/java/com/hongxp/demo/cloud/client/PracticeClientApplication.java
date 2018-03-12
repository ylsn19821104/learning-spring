package com.hongxp.demo.cloud.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PracticeClientApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(PracticeClientApplication.class)
                .web(true)
                .run(args);
    }
}
