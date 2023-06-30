package com.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

    @Configuration
    public class RedisConfig {
        String host = "127.0.0.1"; //로컬서버
        int port = 6379;   //포트
        int timeout = 3000;
        int db = 0;
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        JedisPool pool = new JedisPool(jedisPoolConfig,host,port,timeout,"taewoonglee",db);
        Jedis jedis = pool.getResource();
        @Bean
        public RedisConnectionFactory redisConnectionFactory() {
            return new LettuceConnectionFactory();  // Lettuce 사용
        }
        @Bean
        public RedisTemplate<String,String> redisTemplate() {
            RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
            redisTemplate.setConnectionFactory(redisConnectionFactory());
            redisTemplate.setKeySerializer(new StringRedisSerializer());   // Key: String
            redisTemplate.setValueSerializer(new StringRedisSerializer());  // Value: 직렬화에 사용할 Object 사용하기
            return redisTemplate;
        }
    }

