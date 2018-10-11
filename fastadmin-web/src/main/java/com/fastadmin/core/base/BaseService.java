package com.fastadmin.core.base;

import com.fastadmin.common.model.Pager;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {

    BaseMapper<T> getDao();

    // 添加
    int add(T model);

    int add(Map<String, Object> condition);

    int addList(List<T> list);

    int addList(T[] objs);

    // 删除
    int delete(Object id);

    int delete(Map<String, Object> condition);

    int delete(String key, Object value);

    int delete(String key, Object value, String key2, Object value2);

    int delete(Object ... keyValues);

    int deleteList(Object[] ids);

    int deleteList(List<Object> idList);

    // 修改
    int update(T model);

    int update(Map<String, Object> condition);

    int update(String key, Object value);

    int update(String key, Object value, String key2, Object value2);

    // 查询列表
    List<T> getList();

    List<T> getList(T model);

    List<T> getList(Map<String, Object> condition);

    List<T> getList(String key, Object value);

    List<T> getList(String key, Object value, String key2, Object value2);

    // 分页查询
    PageInfo<T> getList(Pager pager);

    PageInfo<T> getList(Pager pager, T model);

    PageInfo<T> getList(Pager pager, Map<String, Object> condition);

    PageInfo<T> getList(Pager pager, String key, Object value);

    PageInfo<T> getList(Pager pager, String key, Object value, String key2, Object value2);

    // 导出
    PageInfo<T> export(Pager pager);

    PageInfo<T> export(Pager pager, T model);

    PageInfo<T> export(Pager pager, Map<String, Object> condition);

    PageInfo<T> export(Pager pager, String key, Object value);

    PageInfo<T> export(Pager pager, String key, Object value, String key2, Object value2);

    // 唯一查询
    T getOne();

    T getOne(Object id);

    T getOne(Map<String, Object> condition);

    T getOne(String key, Object value);

    T getOne(String key, Object value, String key2, Object value2);

    // 获取行数
    long count();

    long count(T model);

    long count(Map<String, Object> condition);

    long count(String key, Object value);

    long count(String key, Object value, String key2, Object value2);

    // 是否存在
    boolean exist();

    boolean exist(Long id);

    boolean exist(T model);

    boolean exist(Map<String, Object> condition);

    boolean exist(String key, Object value);

    boolean exist(String key, Object value, String key2, Object value2);
}
