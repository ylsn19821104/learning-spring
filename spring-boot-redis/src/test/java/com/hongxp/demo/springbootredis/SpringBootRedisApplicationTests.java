package com.hongxp.demo.springbootredis;

import com.hongxp.demo.springbootredis.dao.RedisClientTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {

    @Test
    public void contextLoads() {
    }

    public static final String USER_FORWARD_CACHE_PREFIX = "myboot:user";// user缓存前缀

    @Autowired
    RedisClientTemplate redisClientTemplate;

    @Test
    public void testSave() {
        redisClientTemplate.setWithExpireTime(USER_FORWARD_CACHE_PREFIX, "hongxp", "123456");
    }

}
