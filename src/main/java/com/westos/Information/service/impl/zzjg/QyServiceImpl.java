package com.westos.Information.service.impl.zzjg;

import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Qiye;
import com.westos.Information.dao.QiyeDao;
import com.westos.Information.service.service.zzjg.QyService;
import com.westos.Information.util.Auth;
import com.westos.Information.util.Cons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * 企业管理
 * @author liuchonghua
 */
@Service
public class QyServiceImpl implements QyService {
    @Autowired
    private QiyeDao dao;
    @Override
    public Qiye find(Msg msg) {
        return dao.findQiyeById(Auth.getUser(msg));
    }

    @Override
    public Msg modify(Msg msg) {
        Qiye qiye = msg.getQiye();
        qiye.setId(Auth.getQiye(msg).getId());
        if (dao.modifyQiye(qiye)>0){
            return new Msg("修改成功", Cons.modify);
        }else {
            return new Msg("修改失败",Cons.err);
        }
    }

    @Override
    public Msg logout(Msg msg) {
        if (dao.emptyFirm(Auth.getQiye(msg))>0){
            HttpSession session = msg.getSession();
            session.removeAttribute(Cons.user);
            session.removeAttribute(Cons.qiye);
            return new Msg("注销成功",Cons.delete);
        }else {
            return new Msg("注销失败",Cons.err);
        }

    }
}
