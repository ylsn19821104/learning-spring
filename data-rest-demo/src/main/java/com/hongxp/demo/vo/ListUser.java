package com.hongxp.demo.vo;

import com.hongxp.demo.entity.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "list", types = User.class)
public interface ListUser {
    String getName();

    Long getId();
}
