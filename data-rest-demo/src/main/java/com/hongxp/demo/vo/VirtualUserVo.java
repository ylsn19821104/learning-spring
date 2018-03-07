package com.hongxp.demo.vo;

import com.hongxp.demo.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "virtual", types = User.class)
public interface VirtualUserVo {
    @Value("#{target.name} #{target.age}")
    String getFullInfo();
}
