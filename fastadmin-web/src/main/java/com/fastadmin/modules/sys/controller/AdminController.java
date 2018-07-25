package com.fastadmin.modules.sys.controller;

import com.fastadmin.common.model.Result;
import com.fastadmin.core.base.BaseController;
import com.fastadmin.core.base.BaseService;
import com.fastadmin.modules.sys.entity.User;
import com.fastadmin.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sys/admin")
public class AdminController extends BaseController<User> {

    @Autowired
    private UserService userService;

    @Override
    protected BaseService<User> getService() {
        return userService;
    }

    protected Result beforeAdd(User model) {
        if (userService.exist("username", model.getUsername())) {
            return error("用户名已存在");
        } else if (userService.exist("mobile", model.getMobile())) {
            return error("手机号码已存在");
        } else if (userService.exist("email", model.getEmail())) {
            return error("邮箱已存在");
        }
        return success();
    }
}
