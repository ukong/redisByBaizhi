package com.tiza.leo.redis_by_springboot;

import com.tiza.leo.redis_by_springboot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Date;
import java.util.UUID;

/**
 * @author leowei
 * @date 2020/12/8  - 0:07
 */
@SpringBootTest(classes=RedisBySpringbootApplication.class)
public class TestRedisTemplate {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedisTemplate(){

        /**
         * redisTemplate对象中 key 和 value 的序列化都是 JdkSerializationRedisSerializer
         *      key: string
         *      value: object
         *      修改默认key序列化方案 :  key  StringRedisSerializer
         */

        //修改key序列化方案   String类型序列
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //修改hash key 序列化方案
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        User user = new User();
        //user 的链式编程需要设置Lombok的 @Accessors(chain = true)
        user.setId(UUID.randomUUID().toString()).setName("小陈").setAge(23).setBir(new Date());
        redisTemplate.opsForValue().set("user", user);//redis进行设置 对象需要经过序列化

        User user1 = (User) redisTemplate.opsForValue().get("user");
        System.out.println(user1);


        redisTemplate.opsForList().leftPush("list",user);

        redisTemplate.opsForSet().add("set",user);

        redisTemplate.opsForZSet().add("zset",user,10);

        redisTemplate.opsForHash().put("map","name",user);


    }

}
