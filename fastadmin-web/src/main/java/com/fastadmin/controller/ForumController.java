package com.fastadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ForumController {

    @RequestMapping("forum/discussion")
    @ResponseBody
    public String index() {
        return "{\"discussionlist\":[{\"tid\":\"2112\",\"posts\":\"3\",\"create_date\":\"1526621429\",\"last_date\":\"1526624337\",\"url\":\"https:\\/\\/forum.fastadmin.net\\/thread\\/2112\",\"title\":\"请问后台系统配置里面有一个存入json数据的方法，如果改为多对象存储呢？\"},{\"tid\":\"2111\",\"posts\":\"0\",\"create_date\":\"1526614054\",\"last_date\":\"1526614054\",\"url\":\"https:\\/\\/forum.fastadmin.net\\/thread\\/2111\",\"title\":\"crud生成出错为啥    求教\"},{\"tid\":\"2110\",\"posts\":\"0\",\"create_date\":\"1526613897\",\"last_date\":\"1526613897\",\"url\":\"https:\\/\\/forum.fastadmin.net\\/thread\\/2110\",\"title\":\"使用一键生成crud命令报错  求大神教教\"},{\"tid\":\"2109\",\"posts\":\"1\",\"create_date\":\"1526609838\",\"last_date\":\"1526614492\",\"url\":\"https:\\/\\/forum.fastadmin.net\\/thread\\/2109\",\"title\":\"群整理：onsubmit是自己写的，当返回false后，表单不会提交，但是再次点击提交按钮没反应是什么情况?\"},{\"tid\":\"2108\",\"posts\":\"1\",\"create_date\":\"1526553912\",\"last_date\":\"1526556793\",\"url\":\"https:\\/\\/forum.fastadmin.net\\/thread\\/2108\",\"title\":\"like 查询时%被过滤了如何解决\"},{\"tid\":\"2107\",\"posts\":\"2\",\"create_date\":\"1526546642\",\"last_date\":\"1526548030\",\"url\":\"https:\\/\\/forum.fastadmin.net\\/thread\\/2107\",\"title\":\"如何上传视频？\"},{\"tid\":\"2106\",\"posts\":\"2\",\"create_date\":\"1526540797\",\"last_date\":\"1526562696\",\"url\":\"https:\\/\\/forum.fastadmin.net\\/thread\\/2106\",\"title\":\"第三方登陆  授权后 无法登陆问题\"},{\"tid\":\"2105\",\"posts\":\"1\",\"create_date\":\"1526539878\",\"last_date\":\"1526541531\",\"url\":\"https:\\/\\/forum.fastadmin.net\\/thread\\/2105\",\"title\":\"一键生成的模型，增删改查时候 数据验证的问题\"},{\"tid\":\"2104\",\"posts\":\"2\",\"create_date\":\"1526531322\",\"last_date\":\"1526533871\",\"url\":\"https:\\/\\/forum.fastadmin.net\\/thread\\/2104\",\"title\":\"请问如何添加json数组到数据库呢？\"},{\"tid\":\"2103\",\"posts\":\"2\",\"create_date\":\"1526526714\",\"last_date\":\"1526539671\",\"url\":\"https:\\/\\/forum.fastadmin.net\\/thread\\/2103\",\"title\":\"点击菜单查找不到控制器\"}]}";
    }
}
