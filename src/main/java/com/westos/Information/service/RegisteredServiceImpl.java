package com.westos.Information.service;

import com.westos.Information.bean.User;
import com.westos.Information.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisteredServiceImpl implements RegisteredService{
    @Autowired
    private UserDao userDao;


    @Override
    public String testSjh(User user) {
        if (userDao.sjhToUser(user)==null||userDao.sjhToUser(user).getSjh()==null||userDao.sjhToUser(user).getSjh()==""){
            return "0";
        }else{
            return "1";
        }
    }
}
