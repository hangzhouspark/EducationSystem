package com.kdgx.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Loginusers)实体类
 *
 * @author makejava
 * @since 2023-02-12 17:09:41
 */
@Data
public class Loginusers {

    private Integer lid;

    private String lusername;

    private String lpassword;

    private Integer lisadmin;


}

