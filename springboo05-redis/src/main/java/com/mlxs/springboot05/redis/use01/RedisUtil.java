package com.mlxs.springboot05.redis.use01;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * RedisUtil类描述:
 *
 * @author yangzhenlong
 * @since 2017/2/16
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 根据key删除
     * @param key
     */
    public void remove(String key){
        if(this.isExistKey(key)){
            redisTemplate.delete(key);
        }
    }

    /**
     * 根据key批量删除
     * @param keys
     */
    public void remove(String... keys){
        for(String key : keys){
            this.remove(key);
        }
    }

    /**
     * 根据key判断是否存在对应的value
     * @param key
     * @return
     */
    public boolean isExistKey(String key){
        return redisTemplate.hasKey(key);
    }

    /**
     * 根据key获取值
     * @param key
     * @return
     */
    public Object get(String key){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, Object value){
        try {
            ValueOperations valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key, value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 写入缓存
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    public boolean set(String key, Object value, Long expireTime){
        try {
            ValueOperations valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
