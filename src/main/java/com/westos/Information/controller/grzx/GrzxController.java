package com.westos.Information.controller.grzx;

import com.westos.Information.bean.Msg;
import com.westos.Information.bean.User;
import com.westos.Information.bean.Validator;
import com.westos.Information.service.service.grzx.GrzxService;
import com.westos.Information.util.Auth;
import com.westos.Information.util.Str;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 个人中心
 */
@RestController
@RequestMapping("/grzx/grxx")
public class GrzxController {
    @Autowired
    private GrzxService service;

    //个人信息
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public User find(HttpServletRequest request) {
        return service.find(new Msg(request.getSession()));
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "/modify", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional//事务
    public Msg modify(@RequestBody User user, HttpServletRequest request) {
        return service.modify(new Msg(request.getSession(), user));
    }

    /**
     * 密码验证
     */
    @RequestMapping(value = "/verification", method = RequestMethod.GET)
    public Validator verification( HttpServletRequest request) {
        User user = new User();
        user.setPass(request.getParameter("pass"));
        return service.verification(new Msg(request.getSession(),user));
    }

}
