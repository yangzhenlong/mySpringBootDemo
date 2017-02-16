package com.mlxs.springboot05.redis;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * RedisConfig类描述: redis配置类
 *
 * @author yangzhenlong
 * @since 2017/2/16
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport{

    /**
     * key生成策略
     * @return
     */
    @Bean
    public KeyGenerator keyGenerator(){
        return new KeyGenerator() {
            @Override
            public String generate(Object targetClass, Method targetMethod, Object... params) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(targetClass.getClass().getName());
                stringBuffer.append("." + targetMethod.getName());
                for (Object param : params){
                    stringBuffer.append("_" + param.toString());
                }

                return stringBuffer.toString();
            }
        };
    }

    /**
     * redis缓存配置
     * @param redisTemplate
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        redisCacheManager.setDefaultExpiration(60 * 5);//设置过期时间 单位：秒

        Map<String, Long> expires = new HashMap<>();
        expires.put("test", 300L);
        redisCacheManager.setExpires(expires);//设置value过期时间
        return redisCacheManager;
    }

    /**
     * 设置redisTemplate
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(factory);

        //设置序列化方式
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        stringRedisTemplate.setValueSerializer(jackson2JsonRedisSerializer);

        stringRedisTemplate.afterPropertiesSet();
        return stringRedisTemplate;
    }
}
