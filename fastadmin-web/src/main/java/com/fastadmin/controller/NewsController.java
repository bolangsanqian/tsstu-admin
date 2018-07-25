package com.fastadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsController {

    @RequestMapping("news/index")
    @ResponseBody
    public String index() {
        return "{\"newslist\":[{\"id\":\"11\",\"title\":\"FastAdmin全新官方交流社区上线\",\"content\":\"FastAdmin全新官方交流社区上线\",\"url\":\"https:\\/\\/forum.fastadmin.net\\/\",\"createtime\":\"1522141222\",\"updatetime\":\"1522141222\",\"weigh\":\"11\",\"status\":\"normal\",\"status_text\":\"正常\"},{\"id\":\"10\",\"title\":\"FastAdmin邀请你加入官方QQ交流群和小伙伴一起交流\",\"content\":\"FastAdmin邀请你加入官方QQ交流群和小伙伴一起交流\",\"url\":\"https:\\/\\/jq.qq.com\\/?_wv=1027&k=487PNBb\",\"createtime\":\"1522141125\",\"updatetime\":\"1522141125\",\"weigh\":\"10\",\"status\":\"normal\",\"status_text\":\"正常\"},{\"id\":\"9\",\"title\":\"FastAdmin邀请你在码云上为FastAdmin点赞\",\"content\":\"FastAdmin邀请你在码云上为FastAdmin点赞\",\"url\":\"https:\\/\\/gitee.com\\/karson\\/fastadmin\",\"createtime\":\"1522141050\",\"updatetime\":\"1522141050\",\"weigh\":\"9\",\"status\":\"normal\",\"status_text\":\"正常\"},{\"id\":\"8\",\"title\":\"Fastadmin插件开发教程之目录文件介绍\",\"content\":\"<p>Fastadmin插件开发教程之目录文件介绍<br><\\/p>\",\"url\":\"http:\\/\\/forum.fastadmin.net\\/d\\/282\",\"createtime\":\"1505395180\",\"updatetime\":\"1505395180\",\"weigh\":\"8\",\"status\":\"normal\",\"status_text\":\"正常\"},{\"id\":\"7\",\"title\":\"FastAdmin插件开发教程之简明开发教程\",\"content\":\"<p>FastAdmin插件开发教程之简明开发教程<br><\\/p>\",\"url\":\"http:\\/\\/forum.fastadmin.net\\/d\\/324\",\"createtime\":\"1505395159\",\"updatetime\":\"1505395159\",\"weigh\":\"7\",\"status\":\"normal\",\"status_text\":\"正常\"},{\"id\":\"5\",\"title\":\"提示“未知的数据格式或网络错误”时该如何排查错误？\",\"content\":\"<p>提示“未知的数据格式或网络错误”时该如何排查错误？<br><\\/p>\",\"url\":\"http:\\/\\/forum.fastadmin.net\\/d\\/56\",\"createtime\":\"1505395088\",\"updatetime\":\"1505395088\",\"weigh\":\"5\",\"status\":\"normal\",\"status_text\":\"正常\"},{\"id\":\"4\",\"title\":\"一张图解析FastAdmin中的表格列表的功能\",\"content\":\"<p>一张图解析FastAdmin中的表格列表的功能<br><\\/p>\",\"url\":\"http:\\/\\/forum.fastadmin.net\\/d\\/323\",\"createtime\":\"1505395069\",\"updatetime\":\"1505395069\",\"weigh\":\"4\",\"status\":\"normal\",\"status_text\":\"正常\"},{\"id\":\"3\",\"title\":\"官方增值服务正式上线！\",\"content\":\"<p>官网增值服务正式上线！<br><\\/p>\",\"url\":\"http:\\/\\/www.fastadmin.net\\/service.html\",\"createtime\":\"1503641537\",\"updatetime\":\"1503641548\",\"weigh\":\"3\",\"status\":\"normal\",\"status_text\":\"正常\"},{\"id\":\"2\",\"title\":\"FastAdmin插件市场正式上线！\",\"content\":\"<p>FastAdmin插件市场正式上线！<br><\\/p>\",\"url\":\"http:\\/\\/www.fastadmin.net\\/store.html\",\"createtime\":\"1503641508\",\"updatetime\":\"1503641508\",\"weigh\":\"2\",\"status\":\"normal\",\"status_text\":\"正常\"},{\"id\":\"1\",\"title\":\"FastAdmin全新官网上线！\",\"content\":\"<p>经过近半个月时间的开发，FastAdmin全新官网正式上线<\\/p>\",\"url\":\"http:\\/\\/www.fastadmin.net\",\"createtime\":\"1503641464\",\"updatetime\":\"1503641464\",\"weigh\":\"1\",\"status\":\"normal\",\"status_text\":\"正常\"}],\"new\":10,\"url\":\"http:\\/\\/www.fastadmin.net?ref=news\"}";
    }
}
