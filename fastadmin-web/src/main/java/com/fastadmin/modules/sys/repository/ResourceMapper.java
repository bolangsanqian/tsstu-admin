package com.fastadmin.modules.sys.repository;

import com.fastadmin.common.annotation.MyDbRepository;
import com.fastadmin.core.base.BaseMapper;
import com.fastadmin.modules.sys.entity.Resource;

@MyDbRepository
public interface ResourceMapper extends BaseMapper<Resource> {
}