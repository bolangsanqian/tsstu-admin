package com.fastadmin.core.base;

import com.fastadmin.common.model.Pager;
import com.fastadmin.common.util.MapUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int add(T model) {
        return this.getDao().add(model);
    }

    @Override
    public int add(Map<String, Object> condition) {
        return this.getDao().add(condition);
    }

    @Transactional
    @Override
    public int addList(List<T> list) {
        return this.getDao().addList(list);
    }

    @Transactional
    @Override
    public int addList(T[] objs) {
        return this.getDao().addList(Arrays.asList(objs));
    }

    @Override
    public int delete(Object id) {
        return this.getDao().delete(id);
    }

    @Override
    public int delete(Map<String, Object> condition) {
        return this.getDao().delete(condition);
    }

    @Override
    public int delete(String key, Object value) {
        Map<String, Object> condition = new HashMap<>();
        condition.put(key, value);
        return this.delete(condition);
    }

    @Override
    public int delete(String key, Object value, String key2, Object value2) {
        Map<String, Object> condition = new HashMap<>();
        condition.put(key, value);
        condition.put(key2, value2);
        return this.delete(condition);
    }

    @Transactional
    @Override
    public int deleteList(Object[] ids) {
        return this.getDao().deleteList(Arrays.asList(ids));
    }

    @Transactional
    @Override
    public int deleteList(List<Object> ids) {
        return this.getDao().deleteList(ids);
    }

    @Override
    public int update(T model) {
        return this.getDao().update(model);
    }

    @Override
    public int update(Map<String, Object> condition) {
        return this.getDao().update(condition);
    }

    @Override
    public int update(String key, Object value) {
        Map<String, Object> condition = new HashMap<>();
        condition.put(key, value);
        return this.update(condition);
    }

    @Override
    public int update(String key, Object value, String key2, Object value2) {
        Map<String, Object> condition = new HashMap<>();
        condition.put(key, value);
        condition.put(key2, value2);
        return this.delete(condition);
    }

    @Override
    public List<T> getList() {
        return this.getDao().getList();
    }

    @Override
    public List<T> getList(T model) {
        return this.getDao().getList(model);
    }

    @Override
    public List<T> getList(Map<String, Object> condition) {
        return this.getDao().getList(condition);
    }

    @Override
    public List<T> getList(String key, Object value) {
        Map<String, Object> condition = new HashMap<>();
        condition.put(key, value);
        return this.getList(condition);
    }

    @Override
    public List<T> getList(String key, Object value, String key2, Object value2) {
        Map<String, Object> condition = new HashMap<>();
        condition.put(key, value);
        condition.put(key2, value2);
        return this.getList(condition);
    }

    @Override
    public PageInfo<T> getList(Pager pager) {
        Page<T> page = PageHelper.startPage(pager.getPageNum(), pager.getPageSize(), true).setOrderBy(pager.getOrderBy());
        return page.toPageInfo();
    }

    @Override
    public PageInfo<T> getList(Pager pager, T model) {
        Page<T> page = PageHelper.startPage(pager.getPageNum(), pager.getPageSize(), true).setOrderBy(pager.getOrderBy());
        Map<String, Object> condition = MapUtils.convertBean2Map(model);
        this.getList(condition);
        return page.toPageInfo();
    }

    @Override
    public PageInfo<T> getList(Pager pager, Map<String, Object> condition) {
        Page<T> page = PageHelper.startPage(pager.getPageNum(), pager.getPageSize(), true).setOrderBy(pager.getOrderBy());
        this.getList(condition);
        return page.toPageInfo();
    }

    @Override
    public PageInfo<T> getList(Pager pager, String key, Object value) {
        Page<T> page = PageHelper.startPage(pager.getPageNum(), pager.getPageSize(), true).setOrderBy(pager.getOrderBy());
        Map<String, Object> condition = new HashMap<>();
        condition.put(key, value);
        this.getList(condition);
        return page.toPageInfo();
    }

    @Override
    public PageInfo<T> getList(Pager pager, String key, Object value, String key2, Object value2) {
        Page<T> page = PageHelper.startPage(pager.getPageNum(), pager.getPageSize(), true).setOrderBy(pager.getOrderBy());
        Map<String, Object> condition = new HashMap<>();
        condition.put(key, value);
        condition.put(key2, value2);
        this.getList(condition);
        return page.toPageInfo();
    }

    @Override
    public PageInfo<T> export(Pager pager) {
        pager.setPageNum(0);
        return this.getList(pager);
    }

    @Override
    public PageInfo<T> export(Pager pager, T model) {
        pager.setPageNum(0);
        return this.getList(pager, model);
    }

    @Override
    public PageInfo<T> export(Pager pager, Map<String, Object> condition) {
        pager.setPageNum(0);
        return this.getList(pager, condition);
    }

    @Override
    public PageInfo<T> export(Pager pager, String key, Object value) {
        pager.setPageNum(0);
        return this.getList(pager, key, value);
    }

    @Override
    public PageInfo<T> export(Pager pager, String key, Object value, String key2, Object value2) {
        pager.setPageNum(0);
        return this.getList(pager, key, value, key2, value2);
    }

    @Override
    public T getOne() {
        return this.getDao().getOne();
    }

    @Override
    public T getOne(Object id) {
        Map<String, Object> condition = new HashMap<>();
        condition.put("id", id);
        return this.getOne(condition);
    }

    @Override
    public T getOne(Map<String, Object> condition) {
        return this.getDao().getOne(condition);
    }

    @Override
    public T getOne(String key, Object value) {
        Map<String, Object> condition = new HashMap<>();
        condition.put(key, value);
        return this.getOne(condition);
    }

    @Override
    public T getOne(String key, Object value, String key2, Object value2) {
        Map<String, Object> condition = new HashMap<>();
        condition.put(key, value);
        condition.put(key2, value2);
        return this.getOne(condition);
    }

    @Override
    public long count() {
        return this.getDao().count();
    }

    @Override
    public long count(T model) {
        return this.getDao().count(model);
    }

    @Override
    public long count(Map<String, Object> condition) {
        return this.getDao().count(condition);
    }

    @Override
    public long count(String key, Object value) {
        Map<String, Object> condition = new HashMap<>();
        condition.put(key, value);
        return this.count(condition);
    }

    @Override
    public long count(String key, Object value, String key2, Object value2) {
        Map<String, Object> condition = new HashMap<>();
        condition.put(key, value);
        condition.put(key2, value2);
        return this.count(condition);
    }

    @Override
    public boolean exist() {
        return this.getDao().exist();
    }

    @Override
    public boolean exist(Long id) {
        Map<String, Object> condition = new HashMap<>();
        condition.put("id", id);
        return this.exist(condition);
    }

    @Override
    public boolean exist(T model) {
        return this.getDao().exist(model);
    }

    @Override
    public boolean exist(Map<String, Object> condition) {
        return this.getDao().exist(condition);
    }

    @Override
    public boolean exist(String key, Object value) {
        Map<String, Object> condition = new HashMap<>();
        condition.put(key, value);
        return this.exist(condition);
    }

    @Override
    public boolean exist(String key, Object value, String key2, Object value2) {
        Map<String, Object> condition = new HashMap<>();
        condition.put(key, value);
        condition.put(key2, value2);
        return this.exist(condition);
    }

}
