package com.hongxp.demo.ribbon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonDcController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/dc")
    public String dc() {
        String url = "http://service-a/dc";
        return restTemplate.getForObject(url, String.class);
    }
}
