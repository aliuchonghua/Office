package com.westos.Information.service.impl.gg;

import com.github.pagehelper.PageHelper;
import com.westos.Information.bean.GgWeidu;
import com.westos.Information.bean.Gonggao;
import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Qiye;
import com.westos.Information.dao.GgDao;
import com.westos.Information.dao.QiyeDao;
import com.westos.Information.service.service.gg.GgService;
import com.westos.Information.service.service.zzjg.QyService;
import com.westos.Information.util.Auth;
import com.westos.Information.util.Cons;
import com.westos.Information.util.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.NewThreadAction;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 公告
 * @author liuchonghua
 */
@Service
public class GgServiceImpl implements GgService {

    @Autowired
    private GgDao dao;

    @Override
    public List<Gonggao> findYdList(Msg msg) {
        return dao.findYdList(Auth.getUser(msg));
    }

    @Override
    public List<Gonggao> findWdList(Msg msg) {
        return dao.findWdList(Auth.getUser(msg));
    }

    @Override
    public List<Gonggao> findZjList(Msg msg) {
        return dao.findZjList(Auth.getUser(msg));
    }

    @Override
    public Msg add(Msg msg) {
        Gonggao gg = msg.getGonggao();
        gg.setId(ID.getID());//id
        gg.setU_id(Auth.getUser(msg).getId());//创建人
        gg.setU_name(Auth.getUser(msg).getName());
        gg.setCjsj(new Date());//创建时间
        gg.setQy_id(Auth.getQiye(msg).getId());//企业
        if (dao.add(gg)>0){
            return new Msg("发布成功",Cons.add);
        }else {
            return new Msg("发布失败",Cons.err);
        }
    }

    @Override
    public Msg haveRead(Msg msg) {
        Gonggao gg = msg.getGonggao();
        GgWeidu wd = new GgWeidu();
        wd.setId(ID.getID());
        wd.setG_id(gg.getId());
        wd.setU_id(Auth.getUser(msg).getId());
        dao.haveRead(wd);
        return new Msg("已读",Cons.add);
    }

    @Override
    public Msg delete(Msg msg) {
        if (dao.delete(msg.getGonggao())>0){
            return new Msg("删除成功",Cons.delete);
        }else {
            return new Msg("删除失败",Cons.err);
        }
    }
}
