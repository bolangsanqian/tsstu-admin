package com.fastadmin.core.base;

import com.fastadmin.common.annotation.MyDbRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@MyDbRepository
public interface BaseMapper<T>{
    // 添加
    int add(T model);

    int add(Map<String, Object> condition);

    int addList(List<T> list);

    int addList(T[] objs);

    // 删除
    int delete(@Param("id")Object id);

    int delete(Map<String, Object> condition);

    int deleteList(List<Object> list);

    // 修改
    int update(T model);

    int update(Map<String, Object> condition);

    // 查询列表
    List<T> getList();

    List<T> getList(T model);

    List<T> getList(Map<String, Object> condition);

    // 导出
    List<T> export();

    List<T> export(T model);

    List<T> export(Map<String, Object> condition);

    // 唯一查询
    T getOne();

    T getOne(T model);

    T getOne(Map<String, Object> condition);

    // 获取行数
    long count();

    long count(T model);

    long count(Map<String, Object> condition);

    // 是否存在
    boolean exist();

    boolean exist(@Param("id")Long id);

    boolean exist(T model);

    boolean exist(Map<String, Object> condition);

}
