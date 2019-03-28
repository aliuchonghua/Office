package com.westos.Information.service.impl.rw;

import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Renwu;
import com.westos.Information.bean.User;
import com.westos.Information.dao.RwDao;
import com.westos.Information.dao.UserDao;
import com.westos.Information.service.service.rw.RwService;
import com.westos.Information.util.Auth;
import com.westos.Information.util.Cons;
import com.westos.Information.util.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 任务
 *
 * @author liuchonghua
 */
@Service
public class RwServiceImpl implements RwService {
    @Autowired
    private RwDao rwDao;
    @Autowired
    private UserDao userDao;

    @Override
    public List<Renwu> findMyRw(Msg msg) {
        Renwu renwu = msg.getRenwu();
        renwu.setZx_id(Auth.getUser(msg).getId());
        return rwDao.findMyRw(renwu);
    }

    @Override
    public List<Renwu> findWXF(Msg msg) {
        Renwu renwu = msg.getRenwu();
        renwu.setU_id(Auth.getUser(msg).getId());
        return rwDao.findWXF(renwu);
    }

    @Override
    public List<User> findXs(Msg msg) {
        User user = Auth.getUser(msg);
        if (user.getZhlx() == 1) {
            return userDao.findBmfzr(user);
        } else if (user.getZhlx() == 2) {
            return userDao.findYg(user);
        } else {
            return null;
        }
    }

    @Override
    public Msg add(Msg msg) {
        Renwu rw = msg.getRenwu();
        rw.setId(ID.getID());
        rw.setU_id(Auth.getUser(msg).getId());
        rw.setU_name(Auth.getUser(msg).getName());
        rw.setType("未开始");
        rw.setQy_id(Auth.getQiye(msg).getId());
        rw.setBm_id(Auth.getUser(msg).getBm_id());
        if (rwDao.add(rw)>0){
            return new Msg("下发成功",Cons.add);
        }else {
            return new Msg("下发失败",Cons.err);
        }
    }

    @Override
    public Msg modify(Msg msg) {
        Renwu renwu = msg.getRenwu();
        Renwu rw=new Renwu();
        rw.setId(renwu.getId());
        rw.setType(renwu.getType());
        rw.setEnd_time(renwu.getEnd_time());
        if (rwDao.modify(rw)>0){
            return new Msg("修改成功",Cons.modify);
        }else {
            return new Msg("修改失败",Cons.err);
        }
    }

    @Override
    public Msg delete(Msg msg) {
        if (rwDao.delete(msg.getRenwu())>0){
            return new Msg("撤销成功",Cons.delete);
        }else{
            return new Msg("撤销失败",Cons.err);
        }
    }
}
