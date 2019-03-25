package com.westos.Information.controller.grzx;

import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Qiye;
import com.westos.Information.bean.User;
import com.westos.Information.service.service.grzx.GrzxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
    @RequestMapping(value = "/verification", method = RequestMethod.POST,consumes = "application/json")
    public Map verification(@RequestBody Map<String, String> pass, HttpServletRequest request) {
        System.err.println(pass);
        Map<String, Boolean> map = new HashMap<>();
        map.put("valid", true);
        return map;
    }

}
