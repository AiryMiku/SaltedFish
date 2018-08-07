package com.airy.saltedfish.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Created by Airy on 2018/8/7
 */

public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 添加
     * @param key
     * @param value
     */
    public void add(final String key,final Object value){
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 有过期时间的添加
     * @param key
     * @param value
     * @param expires
     */
    public void add(final String key,final Object value,final Long expires){
        redisTemplate.opsForValue().set(key,value,expires,TimeUnit.SECONDS);
    }

    /**
     * 删除
     * @param key
     */
    public void delete(String key){
        redisTemplate.delete(key);
    }

    public void update(final String key,final Object value){
        if (get(key) == null){
            throw new NullPointerException("数据不存在");
        }
        redisTemplate.opsForValue().set(key,value);
    }

    public Object get(final String key){
        return redisTemplate.opsForValue().get(key);
    }

}
