package com.tiza.leo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author leowei
 * @date 2020/12/6  - 19:54
 */
public class TestZSet {
    private Jedis jedis;

    @Before
    public void before(){
        this.jedis = new Jedis("192.168.121.102", 7000);
    }

    @After
    public void after(){
        jedis.close();
    }


    //测试ZSET相关
    @Test
    public void testZset() {

        //zadd
        jedis.zadd("znames", 10, "张三");
        jedis.zadd("znames", 111, "张三2");
        jedis.zadd("znames", 12, "张三3");
        jedis.zadd("znames", 152, "张三4");

        //zrange
        Set<String> names = jedis.zrange("znames", 0, -1);
        names.forEach(x -> System.out.println("x = " + x));


        //zcard
        Long znames = jedis.zcard("znames");
        System.out.println("znames = " + znames);

        //zrangeByScore
        Set<String> znames1 = jedis.zrangeByScore("znames", "0", "100", 0, 5);
        znames1.forEach(x-> System.out.println("x = " + x));

        //..

    }
}
