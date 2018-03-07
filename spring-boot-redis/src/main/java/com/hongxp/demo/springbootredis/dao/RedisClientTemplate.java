package com.hongxp.demo.springbootredis.dao;

import com.hongxp.demo.springbootredis.util.RedisClusterProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

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
 * @Date : 2018/3/7 23:02
 */
@Slf4j
@Component
public class RedisClientTemplate {
    @Autowired
    private JedisCluster jedisCluster;
    @Autowired
    private RedisClusterProperties redisClusterProperties;

    private static final String KEY_SPLIT = ":"; //用于隔开缓存前缀与缓存键值 

    /**
     * 设置缓存 
     * @param prefix 缓存前缀（用于区分缓存，防止缓存键值重复）
     * @param key    缓存key
     * @param value  缓存value
     */
    public void set(String prefix, String key, String value) {
        jedisCluster.set(prefix + KEY_SPLIT + key, value);
        log.debug("RedisUtil:set cache key={},value={}", prefix + KEY_SPLIT + key, value);
    }

    /**
     * 设置缓存，并且自己指定过期时间
     * @param prefix
     * @param key
     * @param value
     * @param expireTime 过期时间
     */
    public void setWithExpireTime(String prefix, String key, String value, int expireTime) {
        jedisCluster.setex(prefix + KEY_SPLIT + key, expireTime, value);
        log.debug("RedisUtil:setWithExpireTime cache key={},value={},expireTime={}", prefix + KEY_SPLIT + key, value,
                expireTime);
    }

    /**
     * 设置缓存，并且由配置文件指定过期时间
     * @param prefix
     * @param key
     * @param value
     */
    public void setWithExpireTime(String prefix, String key, String value) {
        int EXPIRE_SECONDS = redisClusterProperties.getExpireSeconds();
        jedisCluster.setex(prefix + KEY_SPLIT + key, EXPIRE_SECONDS, value);
        log.debug("RedisUtil:setWithExpireTime cache key={},value={},expireTime={}", prefix + KEY_SPLIT + key, value,
                EXPIRE_SECONDS);
    }

    /**
     * 获取指定key的缓存
     * @param prefix
     * @param key
     */
    public String get(String prefix, String key) {
        String value = jedisCluster.get(prefix + KEY_SPLIT + key);
        log.debug("RedisUtil:get cache key={},value={}", prefix + KEY_SPLIT + key, value);
        return value;
    }

    /**
     * 删除指定key的缓存
     * @param prefix
     * @param key
     */
    public void deleteWithPrefix(String prefix, String key) {
        jedisCluster.del(prefix + KEY_SPLIT + key);
        log.debug("RedisUtil:delete cache key={}", prefix + KEY_SPLIT + key);
    }

    public void delete(String key) {
        jedisCluster.del(key);
        log.debug("RedisUtil:delete cache key={}", key);
    }
}
