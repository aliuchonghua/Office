package com.westos.Information.service.impl.grzx;

import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Qiye;
import com.westos.Information.bean.User;
import com.westos.Information.dao.QiyeDao;
import com.westos.Information.dao.UserDao;
import com.westos.Information.service.service.grzx.GrzxService;
import com.westos.Information.service.service.zzjg.QyService;
import com.westos.Information.util.Auth;
import com.westos.Information.util.Cons;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 个人中心
 *
 * @author liuchonghua
 */
@Service
public class GrzxServiceImpl implements GrzxService {
    @Autowired
    private UserDao dao;

    @Override
    public User find(Msg msg) {
        return Auth.getUser(msg);
    }

    @Override
    public Msg modify(Msg msg) {
        String pass = msg.getUser().getPass();
        User user = Auth.getUser(msg);
        user.setPass(pass);
        dao.modifyUser(user);
        User userById = dao.findUserById(user);
        msg.getSession().setAttribute(Cons.user, userById);
        return new Msg("修改成功", Cons.modify);


    }
}
