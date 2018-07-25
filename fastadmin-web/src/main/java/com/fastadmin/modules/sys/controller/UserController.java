package com.fastadmin.modules.sys.controller;

import com.fastadmin.core.base.BaseController;
import com.fastadmin.core.base.BaseService;
import com.fastadmin.modules.sys.entity.User;
import com.fastadmin.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User> {

    @Autowired
    private UserService userService;

    @Override
    protected BaseService<User> getService() {
        return userService;
    }
}
