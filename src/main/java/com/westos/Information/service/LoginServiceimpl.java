package com.westos.Information.service;

import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Student;
import com.westos.Information.bean.User;
import com.westos.Information.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginServiceimpl implements LoginService {

    @Autowired
    private UserDao userDao;


    @Override
    public Msg loginmsg(Msg msg) {
        User user = msg.getUser();
        HttpSession session = msg.getSession();
        //根据手机号，密码获取用户
        User userall = userDao.sjhAndPassToUser(user);
        System.err.println("User==>"+userall);
        if (userall==null){
            return new Msg("账户错误");
        }
        //用户写入session
        session.setAttribute("Auth_user",userall);
        //返回信息
        return new Msg("登陆成功",1);
    }
}
