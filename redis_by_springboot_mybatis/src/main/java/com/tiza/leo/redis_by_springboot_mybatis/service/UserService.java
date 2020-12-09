package com.tiza.leo.redis_by_springboot_mybatis.service;

import com.tiza.leo.redis_by_springboot_mybatis.entity.User;

import java.util.List;

/**
 * @author leowei
 * @date 2020/12/8  - 21:09
 */
public interface UserService {
    List<User> findAll();

   User findById(String id);

    void delete(String id);
    void save(User user);

   /*

    void update(User user);*/
}
