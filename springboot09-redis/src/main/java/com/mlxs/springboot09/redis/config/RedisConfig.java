package com.mlxs.springboot09.redis.config;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
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

/**
 * RedisConfig类描述:
 *
 * @author yangzhenlong
 * @since 2017/3/16
 */
@Configuration
@EnableCaching
public class RedisConfig {

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        return new RedisCacheManager(redisTemplate);
    }

    /**
     * redisTemplate对象
     * @param factory
     * @return
     */
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Bean
    public RedisTemplate<String, String> redisTemplate( RedisConnectionFactory factory){
        StringRedisTemplate redisTemplate = new StringRedisTemplate (factory);
        redisTemplate.setValueSerializer(this.getRedisSerializer());
        return redisTemplate;
    }

    /**
     * key生成策略
     * @return
     */
    @Bean
    public KeyGenerator keyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName()).append(".")
                        .append(method.getName()).append("-");//类名.方法名
                if(params.length > 0){
                    for(Object param : params){
                        sb.append("&" + param.toString());//&123&abc
                    }
                }
                return sb.toString();
            }
        };
    }

    /**
     * json序列化对象
     * @return
     */
    private Jackson2JsonRedisSerializer getRedisSerializer(){
        Jackson2JsonRedisSerializer redisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        redisSerializer.setObjectMapper(this.getObjectMapper());
        return redisSerializer;
    }

    private ObjectMapper getObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        return objectMapper;
    }
}
