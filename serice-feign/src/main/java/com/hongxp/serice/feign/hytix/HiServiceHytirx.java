package com.hongxp.serice.feign.hytix;

import com.hongxp.serice.feign.service.HiService;
import org.springframework.stereotype.Component;

@Component
public class HiServiceHytirx implements HiService {
    @Override
    public String sayHi(String name) {
        return "sorry," + name;
    }
}
