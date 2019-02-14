package com.westos.Information.controller;

import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Student;
import com.westos.Information.bean.User;
import com.westos.Information.config.Adminconfig;
import com.westos.Information.service.LoginService;
import com.westos.Information.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;


    //登陆
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Msg login(@RequestBody Msg msg, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        msg.setSession(session);
        return loginService.loginmsg(msg);
    }
    //注销
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("Auth_user");
        try {
            response.sendRedirect("/index.html");
        } catch (IOException e) {
            System.out.println("index重定向失败");
        }

    }

}
