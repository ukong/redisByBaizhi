package com.tiza.leo.redis_by_springboot_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tiza.leo.redis_by_springboot_mybatis.dao")
public class RedisBySpringbootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisBySpringbootMybatisApplication.class, args);
	}

}
