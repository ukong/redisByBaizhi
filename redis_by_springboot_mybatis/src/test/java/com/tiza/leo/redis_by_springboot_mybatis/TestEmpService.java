package com.tiza.leo.redis_by_springboot_mybatis;

import com.tiza.leo.redis_by_springboot_mybatis.entity.Emp;
import com.tiza.leo.redis_by_springboot_mybatis.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leowei
 * @date 2020/12/9  - 20:58
 */

@SpringBootTest(classes = com.tiza.leo.redis_by_springboot_mybatis.RedisBySpringbootMybatisApplication.class)
@RunWith(SpringRunner.class)
public class TestEmpService {
    // @RunWith(SpringRunner.class)基本等同于@RunWith(SpringJUnit4ClassRunner.class)注解的作用：
//让测试在Spring容器环境下执行。如测试类中无此注解，将导致service,dao等自动注入失败。


    @Autowired
    private EmpService empService;

    @Test
    public void testFind(){
        empService.findAll().forEach(emp -> System.out.println("emp = " + emp));
        System.out.println("================");
        empService.findAll().forEach(emp-> System.out.println("emp = " + emp));
    }

    @Test
    public void testFindOne(){
        Emp one = empService.findOne("1");
        System.out.println("one = " + one);
        System.out.println("================");
        empService.findOne("1");
    }

}
