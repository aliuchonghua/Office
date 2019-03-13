package com.westos.Information.controller;

import com.westos.Information.bean.Msg;
import com.westos.Information.bean.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author liuchonghua
 * @version v_2.2_zz
 */
@RestController
@RequestMapping("/dataindex")
public class dataIndexController {
    @RequestMapping(value = "/finduser", method = RequestMethod.GET)
    public Msg finduser(HttpServletRequest request)  {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("Auth_user");
        System.err.println(user);
        Msg msg=new Msg();
        msg.setUser(user);
        return msg;
    }
}
