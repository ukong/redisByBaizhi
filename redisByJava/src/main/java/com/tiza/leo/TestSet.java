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
public class TestSet {

    private Jedis jedis;

    @Before
    public void before(){
        this.jedis = new Jedis("192.168.121.102", 7000);
    }

    @After
    public void after(){
        jedis.close();
    }


    //测试SET相关
    @Test
    public void testSet(){

        //sadd
        Long sadd = jedis.sadd("names", "zhangsan", "lisi");
        System.out.println("sadd = " + sadd);
        Set<String> names = jedis.smembers("names");
        names.forEach(x-> System.out.println("x = " + x)
        );

        //smembers
        jedis.smembers("names");

        //sismember
        Boolean sismember = jedis.sismember("names", "xiaochen");
        System.out.println("sismember = " + sismember);

        //...
    }
}
