package com.hongxp.serice.feign.service;

import com.hongxp.serice.feign.hytix.HiServiceHytirx;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi", fallback = HiServiceHytirx.class)
public interface HiService {
    @GetMapping(value = "/hi")
    String sayHi(@RequestParam(value = "name") String name);
}
