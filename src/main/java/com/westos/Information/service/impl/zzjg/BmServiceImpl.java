package com.westos.Information.service.impl.zzjg;

import com.westos.Information.bean.BmQx;
import com.westos.Information.bean.Bumen;
import com.westos.Information.bean.Msg;
import com.westos.Information.bean.User;
import com.westos.Information.dao.BmQxDao;
import com.westos.Information.dao.BuMenDao;
import com.westos.Information.service.service.zzjg.BmService;
import com.westos.Information.util.Auth;
import com.westos.Information.util.Cons;
import com.westos.Information.util.ID;
import com.westos.Information.util.Str;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BmServiceImpl implements BmService {
    @Autowired
    private BuMenDao dao;
    @Autowired
    private BmQxDao qxDao;

    @Override
    public List<Bumen> findlist(Msg msg) {
        return dao.findlist(Auth.getUser(msg));
    }

    @Override
    public Msg add(Msg msg) {
        User user = Auth.getUser(msg);
        Bumen bumen = msg.getBumen();
        if (Str.isAnyEmpty(bumen.getName())) {
            return new Msg("名称不能为空", Cons.err);
        }
        bumen.setId(ID.getID());
        bumen.setQy_id(user.getQy_id());
        if (dao.findName(bumen) == null) {
            String[] split = bumen.getFjqx().split(",");
            dao.add(bumen);
            if (split[0].length()>6){
                for (String qxid:split){
                    qxDao.save(new BmQx(ID.getID(),bumen.getId(),qxid));
                }
            }
            return new Msg("添加成功", Cons.add);
        } else {
            return new Msg("名称重复", Cons.err);
        }
    }

    @Override
    public Msg modify(Msg msg) {
        User user = Auth.getUser(msg);
        Bumen bumen = msg.getBumen();
        if (Str.isAnyEmpty(bumen.getName())) {
            return new Msg("名称不能为空", Cons.err);
        }
        bumen.setQy_id(user.getQy_id());
        if (dao.findName(bumen) == null) {
            //删除旧权限
            qxDao.delete(bumen);
            //重新添加
            String[] split = bumen.getFjqx().split(",");
            if (split[0].length()>6){
                for (String qxid:split){
                    qxDao.save(new BmQx(ID.getID(),bumen.getId(),qxid));
                }
            }
            dao.modify(bumen);
            return new Msg("修改成功", Cons.modify);
        } else {
            return new Msg("名称重复", Cons.err);
        }
    }

    @Override
    public Msg remove(Msg msg) {
        Integer remove = dao.remove(msg.getBumen());
        if (remove > 0) {
            return new Msg("删除成功", Cons.delete);
        } else {
            return new Msg("删除失败", Cons.err);
        }
    }
}
