package com.westos.Information.controller;

import com.westos.Information.bean.Module;
import com.westos.Information.bean.Msg;
import com.westos.Information.bean.User;
import com.westos.Information.service.service.dataIndex.DataIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author liuchonghua
 * @version v_2.2_zz
 */
@RestController
@RequestMapping("/dataindex")
public class DataIndexController {
    @Autowired
    private DataIndexService service;

    /**
     * 获取当前登陆用户
     */
    @RequestMapping(value = "/finduser", method = RequestMethod.GET)
    public Msg finduser(HttpServletRequest request)  {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("Auth_user");
        System.err.println(user);
        Msg msg=new Msg();
        msg.setUser(user);
        return msg;
    }

    /**
     * 加载当前用户的模块
     */
    @RequestMapping(value = "/loadModel", method = RequestMethod.GET)
    public List<Module> loadModel(HttpServletRequest request)  {
        return service.loadModel(new Msg(request.getSession()));
    }
}
