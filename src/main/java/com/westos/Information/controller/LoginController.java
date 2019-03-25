package com.westos.Information.controller;

import com.westos.Information.bean.Msg;
import com.westos.Information.service.LoginService;
import com.westos.Information.util.Cons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;


    //登陆
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Msg login(@RequestBody Msg msg, HttpServletRequest request)  {
        HttpSession session = request.getSession();
        msg.setSession(session);
        return loginService.loginmsg(msg);
    }
    //注销
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute(Cons.user);
        session.removeAttribute(Cons.qiye);
        try {
            response.sendRedirect("/index.html");
        } catch (IOException e) {
            System.err.println("index重定向失败");
        }

    }

}
