package com.fastadmin.core.base;

import com.fastadmin.common.constant.ValidateGroups;
import com.fastadmin.common.model.Pager;
import com.fastadmin.common.model.Result;
import com.fastadmin.common.util.BeanUtils;
import com.fastadmin.common.util.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract class BaseController<T> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseService<T> baseService;

    protected abstract BaseService<T> getService();

    @RequestMapping(value = "{path}")
    public String location1(HttpServletRequest request) {
        String path = request.getServletPath();
        return path;
    }

    @RequestMapping(value = "{path}.html")
    public String location2(HttpServletRequest request) {
        String ref = request.getParameter("ref");
        if ("addtabs".equals(ref)) {
            return "redirect:/index";
        }
        String path = request.getServletPath();
        return path.substring(0, path.indexOf("."));
    }

    /**
     * 查询所有列表
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Result all() {
        return ResultUtils.success(baseService.getList());
    }

    /**
     * 查询列表
     * @param condition
     * @return
     */
    @RequestMapping(value = "/list.json", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> condition) {
        return ResultUtils.success(baseService.getList(condition));
    }

    /**
     * 分页查询
     * @param pager
     * @param condition
     * @return
     */
    @RequestMapping(value = "/page/list.json", method = RequestMethod.GET)
    @ResponseBody
    public Result pageList(@ModelAttribute Pager pager, @RequestParam Map<String, Object> condition) {
        return success(baseService.getList(pager, condition));
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result detail(@PathVariable(value = "id") Object id) {
        return ResultUtils.success(baseService.getOne(id));
    }

    /**
     * 添加
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result add(@Validated(ValidateGroups.ADD.class) T model) {
        Result result = beforeAdd(model);
        if (!result.ok()) {
            return result;
        }
        BeanUtils.setProperty(model, "createTime", new Date());
        BeanUtils.setProperty(model, "createBy", this.getLoginUserId());
        if (baseService.add(model) > 0) {
            result = success();
        } else {
            result = error();
        }
        afterAdd(result, model);
        return result;
    }

    /**
     * 批量添加
     * @param models
     * @return
     */
    @RequestMapping(value = "/add/list", method = RequestMethod.POST)
    @ResponseBody
    public Result addList(@Validated(ValidateGroups.ADD.class) List<T> models) {
        Result result = beforeAddList(models);
        if (!result.ok()) {
            return result;
        }
        for (T model : models) {
            BeanUtils.setProperty(model, "createTime", new Date());
            BeanUtils.setProperty(model, "createBy", this.getLoginUserId());
        }
        if (baseService.addList(models) > 0) {
            result = success();
        } else {
            result = error();
        }
        afterAddList(result, models);
        return result;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable(value = "id") Object id) {
        Result result = beforeDelete(id);
        if (!result.ok()) {
            return result;
        }
        if (baseService.delete(id) > 0) {
            result = success();
        } else {
            result = error();
        }
        afterDelete(result, id);
        return result;
    }

    /**
     * 批量删除
     * @param idList
     * @return
     */
    @RequestMapping(value = "/del/ids/{idstr}")
    @ResponseBody
    public Result deleteList(@PathVariable(value = "idstr")String idstr) {
        if (StringUtils.isEmpty(idstr)) {
            return error("id为空");
        }
        Object[] ids = idstr.split(",");
        Result result = beforeDeleteList(ids);
        if (!result.ok()) {
            return result;
        }
        if (baseService.deleteList(ids) > 0) {
            result = success();
        } else {
            result = error();
        }
        afterDeleteList(result, ids);
        return result;
    }

    /**
     * 修改
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Result edit(@ModelAttribute @Validated(ValidateGroups.UPDATE.class)T model) {
        Result result = beforeUpdate(model);
        if (!result.ok()) {
            return result;
        }
        BeanUtils.setProperty(model, "updateTime", new Date());
        BeanUtils.setProperty(model, "updateBy", this.getLoginUserId());
        if (baseService.update(model) > 0) {
            result = success();
        } else {
            result = error();
        }
        afterUpdate(result, model);
        return result;
    }

    /**
     * 获取登录用户ID
     * @return
     */
    protected Long getLoginUserId() {
        return new Long(1);
    }

    /**
     * 添加前调用的方法，子类可重写
     * @param model 添加对象
     * @return
     */
    protected Result beforeAdd(T model) {
        return success();
    }

    /**
     * 添加后前调用的方法，子类可重写
     * @param model 添加对象
     * @return
     */
    protected void afterAdd(Result result, T model) {}

    /**
     * 批量添加前调用的方法，子类可重写
     * @param model 添加对象
     * @return
     */
    protected Result beforeAddList(List<T> list) {
        if (null == list || list.size() == 0) {
            return error("列表为空");
        }
        return success();
    }

    /**
     * 批量添加后调用的方法，子类可重写
     * @param model 添加对象
     * @return
     */
    protected void afterAddList(Result result, List<T> list) {}

    /**
     * 修改前调用的方法，子类可重写
     * @param model 修改对象
     * @return
     */
    protected Result beforeUpdate(T model) {
        return success();
    }

    /**
     * 修改后调用的方法，子类可重写
     * @param model 修改对象
     * @return
     */
    protected void afterUpdate(Result result, T model) {}

    /**
     * 删除前调用的方法，子类可重写
     * @param model 添加对象
     * @return
     */
    protected Result beforeDelete(Object id) {
        return success();
    }

    /**
     * 删除前后用的方法，子类可重写
     * @param model 添加对象
     * @return
     */
    protected void afterDelete(Result result, Object id) {}

    /**
     * 批量删除前调用的方法，子类可重写
     * @param model 修改对象
     * @return
     */
    protected Result beforeDeleteList(Object[] idList) {
        return success();
    }

    /**
     * 批量删除后调用的方法，子类可重写
     * @param model 修改对象
     * @return
     */
    protected void afterDeleteList(Result result, Object[] idList) {}

    /**
     * 成功结果
     * @param data 数据
     * @return
     */
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(Result.SUCCESS);
        result.setMsg("操作成功");
        result.setData(data);
        return result;
    }

    /**
     * 成功结果
     * @return
     */
    public static Result success() {
        return success("操作成功");
    }

    /**
     * 成功结果
     * @param msg 提示信息
     * @return
     */
    public static Result success(String msg) {
        Result result = new Result();
        result.setCode(Result.SUCCESS);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    /**
     * 成功结果
     * @param msg 提示信息
     * @param data 返回数据
     * @return
     */
    public static Result success(String msg, Object data) {
        Result result = new Result();
        result.setCode(Result.SUCCESS);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
     * 错误结果
     * @param errorCode 错误码
     * @param msg 提示信息
     * @return
     */
    public static Result error(String errorCode, String msg) {
        Result result = new Result();
        result.setErrorCode(errorCode);
        result.setCode(Result.ERROR);
        result.setMsg(msg);
        return result;
    }

    /**
     * 错误结果
     * @param msg 提示信息
     * @return
     */
    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(Result.ERROR);
        result.setErrorCode("00000");
        result.setMsg(msg);
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setCode(Result.ERROR);
        result.setErrorCode("00000");
        result.setMsg("操作失败");
        return result;
    }
}
