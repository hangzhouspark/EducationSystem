package com.kdgx.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2023-02-12 17:10:40
 */
@Data
public class Student implements Serializable {
    private Integer sid;
    
    private String sname;
    
    private Integer ssex;
    
    private Date sbirthday;
    
    private String sclass;


}

