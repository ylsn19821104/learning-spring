package com.hongxp.redis;

import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Slf4j
public class RedisClient {
    private JedisPool jedisPool;

   /* private ShardedJedis shardedJedis;
    private ShardedJedisPool shardedJedisPool;*/

    public RedisClient() {
        init();
    }

    public static void main(String[] args) {
        RedisClient redisClient = new RedisClient();
        redisClient.op();
    }

    private void init() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(5);
        config.setMaxWaitMillis(30000);
        jedisPool = new JedisPool(config, "127.0.0.1", 6379);

        /*List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        shards.add(new JedisShardInfo("127.0.0.1", 6379, "master"));
        shardedJedisPool = new ShardedJedisPool(config, shards);*/
    }

    public void op() {
        @Cleanup Jedis jedis = jedisPool.getResource();
        log.info("delete all data");
        //jedis.flushDB();

        jedis.mset("key201", "value201",
                "key202", "value202", "key203", "value203", "key204", "value204");
        System.err.println(jedis.mget("key201", "key202", "key203", "key204"));

        log.info("list test....");
        jedis.lpush("stringlists", "vector");
        jedis.lpush("stringlists", "ArrayList");
        jedis.lpush("stringlists", "vector");
        jedis.lpush("stringlists", "vector");
        jedis.lpush("stringlists", "LinkedList");
        jedis.lpush("stringlists", "MapList");
        jedis.lpush("stringlists", "SerialList");
        jedis.lpush("stringlists", "HashList");
        jedis.lpush("numberlists", "3");
        jedis.lpush("numberlists", "1");
        jedis.lpush("numberlists", "5");
        jedis.lpush("numberlists", "2");
    }

}
