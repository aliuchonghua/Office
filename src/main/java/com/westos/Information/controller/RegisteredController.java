package com.westos.Information.controller;

import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Qiye;
import com.westos.Information.bean.User;
import com.westos.Information.service.RegisteredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

/**
 * 注册相关
 */
@RestController
@RequestMapping("/registered")
public class RegisteredController {
    @Autowired
    private RegisteredService registeredService;

    //注册
    @RequestMapping(value = "/CreateQiye",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional//事务
    public Msg CreateQiye(@RequestBody Msg msg){
        return registeredService.CreateQiye(msg);
    }

    //验证账户是否存在
    @RequestMapping(value = "/yzsjhPresence",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Msg testSjh(@RequestBody User user){
        return new Msg(registeredService.testSjh(user));
    }
}
