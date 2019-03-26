package com.westos.Information.service.impl.sp;

import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Qiye;
import com.westos.Information.bean.Shenpi;
import com.westos.Information.bean.User;
import com.westos.Information.dao.SpDao;
import com.westos.Information.dao.UserDao;
import com.westos.Information.service.service.sp.SpService;
import com.westos.Information.util.Auth;
import com.westos.Information.util.Cons;
import com.westos.Information.util.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 审批
 *
 * @author liuchonghua
 */
@Service
public class SpServiceImpl implements SpService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private SpDao spDao;

    @Override
    public List<Shenpi> findMyWFQ(Msg msg) {
        User user = Auth.getUser(msg);
        Shenpi shenpi = msg.getShenpi();
        shenpi.setU_id(user.getId());
        return spDao.findMyWFQ(shenpi);
    }

    @Override
    public List<Shenpi> findMyWsp(Msg msg) {
        User user = Auth.getUser(msg);
        Shenpi shenpi = msg.getShenpi();
        shenpi.setSpr_id(user.getId());
        return spDao.findMyWsp(shenpi);
    }

    @Override
    public Msg add(Msg msg) {
        User user = Auth.getUser(msg);
        Qiye qiye = Auth.getQiye(msg);
        Shenpi sp = msg.getShenpi();
        sp.setId(ID.getID());
        sp.setU_id(user.getId());
        sp.setU_name(user.getName());
        sp.setFqsj(new Date());
        sp.setQy_id(qiye.getId());
        sp.setBm_id(user.getBm_id());
        if (spDao.add(sp) > 0) {
            return new Msg("添加成功", Cons.add);
        } else {
            return new Msg("添加失败", Cons.err);
        }
    }

    @Override
    public Msg remove(Msg msg) {
        if (spDao.remove(msg.getShenpi()) > 0) {
            return new Msg("删除成功", Cons.delete);
        } else {
            return new Msg("删除失败", Cons.err);
        }
    }

    @Override
    public List<User> findleader(Msg msg) {
        User user = Auth.getUser(msg);
        if (user.getZhlx() == 3) {
            return userDao.findLeader(user);
        } else if (user.getZhlx() == 2) {
            return userDao.findBoss(user);
        } else {
            return null;
        }
    }

    @Override
    public Msg update(Msg msg) {
        String id = msg.getShenpi().getId();
        String type = msg.getShenpi().getType();
        Shenpi sp = new Shenpi();
        sp.setId(id);
        sp.setType(type);
        if (spDao.update(sp) > 0) {
            return new Msg("审批完成", Cons.modify);
        } else {
            return new Msg("服务器错误", Cons.err);
        }
    }
}
