package lyx.taotao.controller;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.time.chrono.JapaneseDate;
import java.util.HashSet;

/**
 * @Title redistest
 * @Description
 * @Copyright: 版权所有 (c) 2018 - 2019
 * @Company: 电子商务中心
 * @Author lyx
 * @Version 1.0.0
 * @Create 2018\12\25 0025 15:13
 */


public class redistest {
    //    单机测试
    @Test
    public void jedissingle(){
        Jedis jedis=new Jedis("192.168.217.135",6379);
        jedis.auth("123456");
        jedis.set("abc","plm");
        System.out.println(jedis.get("abc"));
        jedis.close();
    }
    //    连接池测试
    @Test
    public void jedispool(){
        JedisPool pool=new JedisPool("127.0.0.1",6379);
        Jedis jedis=pool.getResource();
        jedis.auth("zhongguo");
        String s=jedis.get("abc");
        System.out.println(s);
        jedis.close();
        pool.close();
    }
    //    集群测试
    @Test
    public void jediscluter(){
        HashSet<HostAndPort> set=new HashSet<>();
        for(int i=7001;i<=7006;i++){
            HostAndPort hostAndPort = new HostAndPort("192.168.217.135", i);
            set.add(hostAndPort);
        }
        JedisCluster jedisCluster=new JedisCluster(set);
        jedisCluster.set("k1","123456");
        System.out.println(jedisCluster.get("k1"));
        jedisCluster.close();
    }

    @Test
    public void springjedissingle(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/spring_*.xml");
        JedisPool pool = (JedisPool) applicationContext.getBean("redissingle");
        Jedis jedis=pool.getResource();
        System.out.println(jedis.get("k1"));
        jedis.close();
        pool.close();
    }

    @Test
    public void springjediscluster(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/spring_*.xml");
        JedisCluster jedisCluster= (JedisCluster) applicationContext.getBean("rediscluster");
        jedisCluster.set("k1","123");
        System.out.println(jedisCluster.get("k1"));
        jedisCluster.close();
    }
}

