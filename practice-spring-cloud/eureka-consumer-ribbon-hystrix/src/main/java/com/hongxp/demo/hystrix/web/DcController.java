package com.hongxp.demo.hystrix.web;

import com.hongxp.demo.hystrix.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {
    @Autowired
    ConsumerService consumerService;

    @GetMapping("/dc")
    String dc() {
        return consumerService.dc();
    }
}
