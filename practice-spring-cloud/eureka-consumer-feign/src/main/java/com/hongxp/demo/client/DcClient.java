package com.hongxp.demo.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("practice-eureka-client")
public interface DcClient {
    @GetMapping("/dc")
    String dc();
}
