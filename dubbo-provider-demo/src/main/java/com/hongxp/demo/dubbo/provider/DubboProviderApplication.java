package com.hongxp.demo.dubbo.provider;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath:spring/applicationContext-context.xml"})
@SpringBootApplication
@DubboComponentScan(basePackages = "com.hongxp.demo.dubbo.provider.service")
public class DubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class, args);
    }
}
