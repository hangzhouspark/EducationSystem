package com.kdgx.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Video)实体类
 *
 * @author makejava
 * @since 2023-02-12 17:10:40
 */
@Data
public class Video implements Serializable {

    private Integer vid;

    private String vname;

    private String vauthor;

    private String vware;


}

