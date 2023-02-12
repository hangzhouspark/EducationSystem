package com.kdgx.service.impl;

import com.kdgx.entity.Loginusers;
import com.kdgx.mapper.LoginusersMapper;
import com.kdgx.service.LoginusersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginusersServiceImpl implements LoginusersService {

    @Autowired
    private LoginusersMapper loginusersMapper;
    @Override
    public Loginusers loginAllUser(Loginusers entity) {
        return loginusersMapper.loginAllUser(entity);
    }
}
