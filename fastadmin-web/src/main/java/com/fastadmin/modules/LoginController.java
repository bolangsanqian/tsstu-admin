package com.fastadmin.modules;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping(value = {"login", "/login.html"})
    public String login() {
        return "login";
    }
}
