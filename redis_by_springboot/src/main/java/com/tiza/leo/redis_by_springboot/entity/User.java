package com.tiza.leo.redis_by_springboot.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author leowei
 * @date 2020/12/8  - 0:11
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {
    private    String id;
    private String name;
    private Integer age;
    private Date bir;
}
