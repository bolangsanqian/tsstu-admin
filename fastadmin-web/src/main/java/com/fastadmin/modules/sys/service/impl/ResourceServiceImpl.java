package com.fastadmin.modules.sys.service.impl;

import com.fastadmin.common.enums.ResourceType;
import com.fastadmin.common.enums.Status;
import com.fastadmin.common.util.CommonUtils;
import com.fastadmin.core.base.BaseMapper;
import com.fastadmin.core.base.BaseServiceImpl;
import com.fastadmin.modules.sys.entity.Menu;
import com.fastadmin.modules.sys.entity.Resource;
import com.fastadmin.modules.sys.entity.User;
import com.fastadmin.modules.sys.repository.ResourceMapper;
import com.fastadmin.modules.sys.repository.UserMapper;
import com.fastadmin.modules.sys.service.ResourceService;
import com.fastadmin.modules.sys.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resource> implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public BaseMapper<Resource> getDao() {
        return resourceMapper;
    }

    @Override
    public List<Menu> buildLeftMenu() {
        // 查询所有菜单
        List<Menu> menuList = new ArrayList<>(); // 根节点菜单
        List<Resource> all = this.getList("status", Status.enable.getValue());
        if (!CommonUtils.isNullOrEmpty(all)) {
            for (Resource resource : all) {
                if (0 == resource.getParentId()) {
                    Menu menu = new Menu();
                    BeanUtils.copyProperties(resource, menu);
                    menu.setSubMenuList(new ArrayList<Menu>());
                    menuList.add(menu);
                    loadChild(all, menu);
                }
            }
            Collections.sort(menuList, new Comparator<Menu>() {
                @Override
                public int compare(Menu o1, Menu o2) {
                    return o1.getSort().compareTo(o2.getSort());
                }
            });
        }
        return menuList;
    }

    /**
     * 加载子菜单
     * @param list
     * @param resource
     */
    private void loadChild(List<Resource> list, Menu menu) {
        List<Menu> menus = new ArrayList<>();
        for (Resource resource : list) {
            if (menu.getResourceId() == resource.getParentId()) {
                Menu subMenu = new Menu();
                BeanUtils.copyProperties(resource, subMenu);
                menu.getSubMenuList().add(subMenu);
                if (ResourceType.menu.getValue() == resource.getType()) {
                    loadChild(list, subMenu);
                }
            }
        }
        List<Menu> subMenus = menu.getSubMenuList();
        Collections.sort(subMenus, new Comparator<Menu>() {
            @Override
            public int compare(Menu o1, Menu o2) {
                return o1.getSort().compareTo(o2.getSort());
            }
        });
    }
}
