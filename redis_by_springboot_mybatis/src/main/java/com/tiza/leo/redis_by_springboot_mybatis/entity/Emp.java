package com.tiza.leo.redis_by_springboot_mybatis.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * @author leowei
 * @date 2020/12/9  - 20:52
 */
@Data
@Accessors(chain = true)
public class Emp implements Serializable {
    private String id;
    private String name;
}
