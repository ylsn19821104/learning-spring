package com.hongxp.demo.springbootredis.conf;

import com.hongxp.demo.springbootredis.util.RedisClusterProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @Description :
 * ---------------------------------
 * @Author : Xianping.Hong
 * @Date : 2018/3/7 22:56
 */
@Configuration
public class JedisClusterConfig {
    @Autowired
    private RedisClusterProperties redisClusterProperties;

    @Bean
    public JedisCluster jedisCluster() {
        String[] nodes = redisClusterProperties.getClusterNodes().split(",");
        Set<HostAndPort> hostAndPorts = new HashSet<>();
        String[] pair;
        for (int i = 0; i < nodes.length; i++) {
            pair = nodes[i].split(":");
            hostAndPorts.add(new HostAndPort(pair[0].trim(), Integer.valueOf(pair[1].trim())));
        }
        return new JedisCluster(hostAndPorts, redisClusterProperties.getCommandTimeout());
    }
}
