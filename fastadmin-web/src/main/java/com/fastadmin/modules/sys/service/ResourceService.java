package com.fastadmin.modules.sys.service;

import com.fastadmin.core.base.BaseService;
import com.fastadmin.modules.sys.entity.Menu;
import com.fastadmin.modules.sys.entity.Resource;
import com.fastadmin.modules.sys.entity.User;

import java.util.List;

public interface ResourceService extends BaseService<Resource> {

    List<Menu> buildLeftMenu();
}
