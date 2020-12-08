package com.tiza.leo.redis_by_springboot_mybatis.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author leowei
 * @date 2020/12/8  - 21:08
 */

@Data
@Accessors(chain = true)
public class User implements Serializable {
    //因为mybatis 会将此类用于resultType返回类型，需要增加  implements Serializable  ， 不然会报这个错误
    //Caused by: java.io.NotSerializableException: com.tiza.leo.redis_by_springboot_mybatis.entity.User
    private  String id;
    private String name;
    private Integer age;
    private Date bir;
}
