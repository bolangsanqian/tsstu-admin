package com.fastadmin.modules.sys.repository;

import com.fastadmin.common.annotation.MyDbRepository;
import com.fastadmin.core.base.BaseMapper;
import com.fastadmin.modules.sys.entity.User;

@MyDbRepository
public interface UserMapper extends BaseMapper<User> {
}