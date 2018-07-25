package com.fastadmin.modules;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping(value = {"/", "/index", "/index.html"})
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("modulename", "admin");
        mv.addObject("controllername", "index");
        mv.addObject("actionname", "index");
        mv.addObject("jsname", "backend/index");
        mv.addObject("moduleurl", "index");
        return mv;
    }
}
