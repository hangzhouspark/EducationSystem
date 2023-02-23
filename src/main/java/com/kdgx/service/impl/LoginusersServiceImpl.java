package com.kdgx.service.impl;

import com.kdgx.entity.Loginusers;
import com.kdgx.mapper.LoginusersMapper;
import com.kdgx.service.LoginusersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginusersServiceImpl implements LoginusersService {

    @Autowired
    private LoginusersMapper loginusersMapper;

    @Override
    public Loginusers loginAllUser(Loginusers entity) {
        return loginusersMapper.loginAllUser(entity);
    }

    @Override
    public List<Loginusers> selectLoginUsers() {
        return loginusersMapper.selectLoginUsers();
    }

    @Override
    public int insertlogin(Loginusers entity) {
        return loginusersMapper.insertlogin(entity);
    }

    @Override
    public int deleteLogin(Loginusers entity) {
        return loginusersMapper.deleteLogin(entity);
    }

    @Override
    public Loginusers selectLoginUsersBylid(Loginusers entity) {
        return loginusersMapper.selectLoginUsersBylid(entity);
    }

    @Override
    public int updateLogin(Loginusers entity) {
        return loginusersMapper.updateLogin(entity);
    }
}
