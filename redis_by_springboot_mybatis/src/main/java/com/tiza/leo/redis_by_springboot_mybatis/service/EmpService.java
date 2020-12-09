package com.tiza.leo.redis_by_springboot_mybatis.service;

import com.tiza.leo.redis_by_springboot_mybatis.entity.Emp;

import java.util.List;

/**
 * @author leowei
 * @date 2020/12/9  - 20:53
 */
public interface EmpService {
    List<Emp> findAll();

    Emp findOne(String id);
}
