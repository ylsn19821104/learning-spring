package com.hongxp.demo.cloud.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PracticeServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(PracticeServerApplication.class)
                .web(true)
                .run(args);
    }
}
