package com.kdgx.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Message)实体类
 *
 * @author makejava
 * @since 2023-02-12 17:10:40
 */
@Data
public class Message implements Serializable {

    private Integer mid;
    
    private String mquestion;
    
    private String manswers;
    
    private Integer tid;

}

