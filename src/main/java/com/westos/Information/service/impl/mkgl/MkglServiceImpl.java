package com.westos.Information.service.impl.mkgl;

import com.westos.Information.Util.ID;
import com.westos.Information.Util.Str;
import com.westos.Information.bean.Module;
import com.westos.Information.bean.Msg;
import com.westos.Information.bean.User;
import com.westos.Information.dao.ModuleDao;
import com.westos.Information.service.service.mkgl.MkglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class MkglServiceImpl implements MkglService {
    @Autowired
    private ModuleDao moduleDao;

    @Override
    public List<Module> findlist(Module module, HttpSession session) {
        User user = (User) session.getAttribute("Auth_user");
        module.setQy_id(user.getQy_id());
        return moduleDao.findlist(module);
    }

    @Override
    public Msg add(Module module, HttpSession session) {
        User user = (User) session.getAttribute("Auth_user");
        System.err.println("module====>"+module);
        if (Str.isAnyEmpty(module.getId())) {
            module.setQy_id(user.getQy_id());
            module.setId(ID.getID());
            moduleDao.add(module);
            return new Msg("添加成功", 1);
        } else {
            moduleDao.modify(module);
            return new Msg("修改成功", 2);
        }
    }

    @Override
    public Msg remove(Module module, HttpSession session) {
        if (Str.isNotAnyEmpty(module.getId())){
            moduleDao.remove(module);
            return new Msg("删除模块"+module.getName()+"成功", 0);
        }else {
            return new Msg("删除失败",-1);
        }

    }
}
