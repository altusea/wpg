package com.example.wpg.service;

import com.example.wpg.model.mo.OperatorMO;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CacheService {

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    public void saveObj(String k, Object v) {
        redisTemplate.opsForValue().set(k, v, 5, TimeUnit.MINUTES);
    }

    public OperatorMO get(String k) {
        return (OperatorMO) redisTemplate.opsForValue().get(k);
    }

    public Long getTTL(String k) {
        return redisTemplate.getExpire(k);
    }
}
