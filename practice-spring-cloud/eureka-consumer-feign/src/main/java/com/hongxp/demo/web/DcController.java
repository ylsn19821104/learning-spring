package com.hongxp.demo.web;

import com.hongxp.demo.client.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {
    @Autowired
    DcClient dcClient;

    @RequestMapping("/dc")
    public String dc() {
        return dcClient.dc();
    }
}
