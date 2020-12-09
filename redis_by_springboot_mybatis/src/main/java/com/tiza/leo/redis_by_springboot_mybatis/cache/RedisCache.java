package com.tiza.leo.redis_by_springboot_mybatis.cache;

import com.tiza.leo.redis_by_springboot_mybatis.util.ApplicationContextUtils;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.DigestUtils;

/**
 * @author leowei
 * @date 2020/12/8  - 22:25
 */
public class RedisCache implements Cache {

    private final String id;

    public RedisCache(String id){
        System.out.println("id:=====================> " + id);
        this.id=id;
    }


    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        System.out.println(" =====================================put start ======== ");
        /*System.out.println("key:" + key.toString());
        System.out.println("value:" + value);
        // //通过application工具类获取redisTemplate
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        */
        getRedisTemplate().opsForHash().put(id.toString(),getKey2MD5(key.toString()),value);
        System.out.println(" =====================================put end  ======== ");

    }

    @Override
    public Object getObject(Object key) {

        System.out.println("---------------------------------get  start-------------");
       /* System.out.println("key:" + key.toString());
//        //通过application工具类获取redisTemplate
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());*/
        System.out.println("------------------------------------get end");
        return getRedisTemplate().opsForHash().get(id.toString(), getKey2MD5( key.toString()));
    }

    //注意:这个方法为mybatis保留方法 默认没有实现 后续版本可能会实现
    @Override
    public Object removeObject(Object key) {
        System.out.println("根据指定key删除缓存");
        return null;
    }
    @Override
    public void clear() {
        System.out.println("清空缓存~~~");
        //清空namespace
        getRedisTemplate().delete(id.toString());//清空缓存
    }

    @Override
    public int getSize() {
        return 0;
    }


    //封装redisTemplate
    private RedisTemplate getRedisTemplate(){
        //通过application工具类获取redisTemplate
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    private String getKey2MD5(String key){
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }


}
