package com.fastadmin.modules.sys.service.impl;

import com.fastadmin.core.base.BaseMapper;
import com.fastadmin.core.base.BaseServiceImpl;
import com.fastadmin.modules.sys.entity.User;
import com.fastadmin.modules.sys.repository.UserMapper;
import com.fastadmin.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseMapper<User> getDao() {
        return userMapper;
    }

}
