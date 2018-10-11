package com.fastadmin.modules.sys.controller;

import com.fastadmin.common.model.Result;
import com.fastadmin.core.base.BaseController;
import com.fastadmin.core.base.BaseService;
import com.fastadmin.modules.sys.entity.Menu;
import com.fastadmin.modules.sys.entity.Resource;
import com.fastadmin.modules.sys.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("sys/menu")
public class MenuController extends BaseController<Resource> {

    @Autowired
    private ResourceService resourceService;

    @Override
    protected BaseService<Resource> getService() {
        return resourceService;
    }

    @RequestMapping("/tree")
    @ResponseBody
    public Result leftTree() {
        List<Menu> list = resourceService.buildLeftMenu();
        return success(list);
    }
}
