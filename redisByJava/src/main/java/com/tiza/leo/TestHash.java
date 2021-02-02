package com.tiza.leo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author leowei
 * @date 2020/12/6  - 19:54
 */
public class TestHash {
    private Jedis jedis;

    @Before
    public void before(){
        //this.jedis = new Jedis("192.168.121.102", 7000);
        this.jedis = new Jedis("192.168.213.41", 6379);
    }

    @After
    public void after(){
        jedis.close();
    }


    //测试HASH相关
    @Test
    public void testHash(){
        //hset
        jedis.hset("maps","name","zhangsan");
        jedis.hset("maps","name2","zhangsan2");
        jedis.hset("maps","name3","zhangsan3");
        jedis.hset("maps","name4","zhangsan4");
        jedis.hset("maps","name5","zhangsan5");
        jedis.hset("maps","name6","zhangsan6");
        //hget
        String hget = jedis.hget("maps", "name");
        System.out.println("hget = " + hget);

        //hgetall
        Map<String, String> maps = jedis.hgetAll("maps");
         maps.entrySet().stream().forEach(x-> System.out.println("x = " + x));
        System.out.println(" ====================================================== ");
         maps.entrySet().stream().sorted((e1,e2)->e1.getKey().compareTo(e2.getKey())).forEach(x-> System.out.println("y = " + x));

        System.out.println("==========================");
        //hkeys
        Set<String> keys1 = jedis.hkeys("maps");
        System.out.println("keys1 = " + keys1);

        //hvals
        List<String> hvals = jedis.hvals("maps");
        System.out.println("hvals = " + hvals);

        //....
    }

}
