package com.tiza.leo.redis_by_springboot_mybatis.service;

import com.tiza.leo.redis_by_springboot_mybatis.dao.EmpDAO;
import com.tiza.leo.redis_by_springboot_mybatis.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author leowei
 * @date 2020/12/9  - 20:54
 */
@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
   private EmpDAO empDAO;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Emp> findAll() {
        return empDAO.findAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Emp findOne(String id) {
        return empDAO.findOne(id);
    }


}
