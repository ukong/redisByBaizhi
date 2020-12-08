package com.tiza.leo.redis_by_springboot_mybatis.service;

import com.tiza.leo.redis_by_springboot_mybatis.dao.UserDAO;
import com.tiza.leo.redis_by_springboot_mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author leowei
 * @date 2020/12/8  - 21:10
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(String id) {
        return userDAO.findById(id);
    }

    @Override
    public void delete(String id) {
         userDAO.delete(id);
    }


}
