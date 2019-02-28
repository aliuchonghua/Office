package com.westos.Information.service;

import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Qiye;
import com.westos.Information.bean.User;
import com.westos.Information.dao.QiyeDao;
import com.westos.Information.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisteredServiceImpl implements RegisteredService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private QiyeDao qiyeDao;
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
        user.setZhlx(0);
        userDao.addUser(user);
        qiye.setGly_id(user.getId());
        //创建企业
        qiyeDao.addQiye(qiye);
        //更新用户
        user.setQy_id(qiye.getId());
        user.setQy_name(qiye.getName());
        user.setName(qiye.getName()+"管理员");
        userDao.modifyUser(user);
        return new Msg("成功注册" + qiye.getName(),1);
    }
}
