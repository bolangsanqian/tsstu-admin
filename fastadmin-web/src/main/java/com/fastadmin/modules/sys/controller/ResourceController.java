package com.fastadmin.modules.sys.controller;

import com.fastadmin.common.model.Result;
import com.fastadmin.core.base.BaseController;
import com.fastadmin.core.base.BaseService;
import com.fastadmin.modules.sys.entity.Resource;
import com.fastadmin.modules.sys.entity.User;
import com.fastadmin.modules.sys.service.ResourceService;
import com.fastadmin.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("sys/resource")
public class ResourceController extends BaseController<Resource> {

    @Autowired
    private ResourceService resourceService;

    @Override
    protected BaseService<Resource> getService() {
        return resourceService;
    }

}
