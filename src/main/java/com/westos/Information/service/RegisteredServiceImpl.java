package com.westos.Information.service;

import com.westos.Information.util.ID;
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
        if (userDao.findsjhToUser(user)==null){
            return "0";
        }
        return "1";
    }

    @Override
    public Msg CreateQiye(Msg msg) {
        User user = msg.getUser();
        Qiye qiye = msg.getQiye();
        System.err.println("新用户=======>"+user);
        System.err.println("新企业=======>"+qiye);
        //检查企业重复
        if (qiyeDao.findNameToQiye(qiye)!=null){
            return new Msg("已存在相同的企业名",-1);
        }
        //补全用户
        user.setZhlx(0);//账户类型
        user.setId(ID.getID());
        //用户id写入企业
        qiye.setGly_id(user.getId());
        //创建企业
        qiye.setId(ID.getID());
        qiyeDao.addQiye(qiye);
        //创建用户
        user.setQy_id(qiye.getId());
        user.setQy_name(qiye.getName());
        user.setName("管理员");
        userDao.addUser(user);
        return new Msg("成功注册" + qiye.getName(),1);
    }
}
