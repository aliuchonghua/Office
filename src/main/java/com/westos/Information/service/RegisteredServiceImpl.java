package com.westos.Information.service;

import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Qiye;
import com.westos.Information.bean.User;
import com.westos.Information.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisteredServiceImpl implements RegisteredService {
    @Autowired
    private UserDao userDao;
    @Override
    public String testSjh(User user) {
        if (userDao.sjhToUser(user) == null || userDao.sjhToUser(user).getSjh() == null || userDao.sjhToUser(user).getSjh() == "") {
            return "0";
        } else {
            return "1";
        }
    }

    @Override
    public Msg CreateQiye(Msg msg) {
        User user = msg.getUser();
        Qiye qiye = msg.getQiye();
        System.err.println("新用户=======>"+user);
        System.err.println("新企业=======>"+qiye);
//        创建用户
        userDao.addUser(user);
        System.out.println(user);
        return new Msg("成功注册" + qiye.getName());
    }
}
