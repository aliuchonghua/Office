package com.westos.Information.service.impl.zzjg;

import com.westos.Information.bean.Bumen;
import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Qiye;
import com.westos.Information.bean.User;
import com.westos.Information.dao.UserDao;
import com.westos.Information.service.service.zzjg.RyService;
import com.westos.Information.util.Cons;
import com.westos.Information.util.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuchonghua
 */
@Service
public class RyServiceImpl implements RyService {
    @Autowired
    private UserDao dao;

    @Override
    public List<User> findlist(Msg msg) {
        return dao.findList(msg.getBumen());
    }

    @Override
    public Msg add(Msg msg) {
        //查重复
        if (dao.findsjhToUser(msg.getUser())!=null){
            return new Msg("手机号重复", Cons.err);
        }else {
            User user = msg.getUser();
            user.setId(ID.getID());
            //获取当前登陆账户企业id
            Qiye qiye = (Qiye) msg.getSession().getAttribute(Cons.qiye);
            user.setQy_id(qiye.getId());
            System.err.println("新用户======>"+user);
            dao.addUser(user);
            return new Msg("添加成功", Cons.add);
        }
    }

    @Override
    public Msg modify(Msg msg) {
        return null;
    }

    @Override
    public Msg remove(Msg msg) {
        return null;
    }
}
