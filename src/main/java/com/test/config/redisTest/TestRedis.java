package com.test.config.redisTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
public class TestRedis {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String host = "127.0.0.1"; //로컬서버
        int port = 6379;   //포트
        int timeout = 3000;
        int db = 0;
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        JedisPool pool = new JedisPool(jedisPoolConfig,host,port,timeout,"taewoonglee",db);
        Jedis jedis = pool.getResource();
        //Connect 체크
        System.out.println(jedis.isConnected());
        jedis.set("key1", "apple");
        jedis.set("key2", "banana");
        jedis.set("key3", "grape");
        // 데이터의 만료시간을 지정
        jedis.expire("key5",1);
        System.out.println("key3: "+jedis.get("key3"));
/*	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }*/
        System.out.println("key5: "+jedis.get("key5"));
        if( jedis != null ){
            System.out.println("클로즈");
            jedis.close();
        }
        pool.close();
        System.out.println("key6: "+jedis.get("key6"));
    }
}