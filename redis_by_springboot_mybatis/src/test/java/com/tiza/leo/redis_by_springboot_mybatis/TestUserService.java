package com.tiza.leo.redis_by_springboot_mybatis;

import com.tiza.leo.redis_by_springboot_mybatis.entity.User;
import com.tiza.leo.redis_by_springboot_mybatis.service.UserService;
import org.apache.ibatis.cache.Cache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leowei
 * @date 2020/12/8  - 21:18
 */
@SpringBootTest(classes = RedisBySpringbootMybatisApplication.class )
@RunWith(SpringRunner.class)
// @RunWith(SpringRunner.class)基本等同于@RunWith(SpringJUnit4ClassRunner.class)注解的作用：
//让测试在Spring容器环境下执行。如测试类中无此注解，将导致service,dao等自动注入失败。
public class TestUserService {

    @Autowired
    private UserService userService;

    /*//如下，想看mybatis的Cache接口有哪些实现
    org.apache.ibatis.cache.Cache cache;*/

    @Test
    public void testFindAll(){
        System.out.println(" =================================================================first findAll" );
        userService.findAll().forEach(u-> System.out.println("u = " + u));
        System.out.println(" ================================================================second findAll ");
        userService.findAll().forEach(u-> System.out.println("u = " + u));
    }

    @Test
    public void testFindOne(){
        User user01 = userService.findById("1");
        System.out.println("==================================");
        User user02 = userService.findById("1");
    }


    @Test
    public void testDelete(){
        userService.delete("1");
    }

}
