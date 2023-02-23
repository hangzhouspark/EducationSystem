package com.kdgx.mapper;

import com.kdgx.entity.Loginusers;

import java.util.List;

public interface LoginusersMapper {

    /**
     * 登陆方法
     *
     * @param entity
     * @return
     */
    public Loginusers loginAllUser(Loginusers entity);

    /**
     * 查询所有登录用户信息
     *
     * @return
     */
    public List<Loginusers> selectLoginUsers();


    /**
     * 添加登录账户
     *
     * @param entity
     * @return
     */
    public int insertlogin(Loginusers entity);

    /**
     * 删除登录账户
     *
     * @param entity
     * @return
     */
    public int deleteLogin(Loginusers entity);

    /**
     * 回显单个登录信息
     *
     * @param entity
     * @return
     */
    public Loginusers selectLoginUsersBylid(Loginusers entity);

    /**
     * 更新登录用户数据
     *
     * @param entity
     * @return
     */
    public int updateLogin(Loginusers entity);


}
