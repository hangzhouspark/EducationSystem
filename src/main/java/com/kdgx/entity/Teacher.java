package com.kdgx.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Teacher)实体类
 *
 * @author makejava
 * @since 2023-02-12 17:10:40
 */
@Data
public class Teacher implements Serializable {
    private Integer tid;

    private String tname;

    private Integer tsex;

    private Date tbirthday;

    private String tdepart;


}

