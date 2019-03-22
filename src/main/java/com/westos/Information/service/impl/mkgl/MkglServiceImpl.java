package com.westos.Information.service.impl.mkgl;

import com.westos.Information.bean.Bumen;
import com.westos.Information.bean.Module;
import com.westos.Information.bean.Msg;
import com.westos.Information.bean.User;
import com.westos.Information.dao.ModuleDao;
import com.westos.Information.service.service.mkgl.MkglService;
import com.westos.Information.util.Auth;
import com.westos.Information.util.Cons;
import com.westos.Information.util.ID;
import com.westos.Information.util.Str;
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
        User user = (User) session.getAttribute(Cons.user);
        module.setQy_id(user.getQy_id());
        return moduleDao.findlist(module);
    }

    @Override
    public List<Module> findMk(Msg msg) {
        return moduleDao.findModuleByQiye(Auth.getUser(msg));
    }

    @Override
    public Bumen fingModuleByname(Msg msg) {
        String fjqxName = msg.getBumen().getFjqx();
        if (Str.isNotAnyEmpty(fjqxName) && fjqxName.length() > 1) {
            String[] split = fjqxName.split(",");
            StringBuilder ids = new StringBuilder();
            for (int i = 0; i < split.length; i++) {
                Module module = new Module();
                module.setName(split[i]);
                module.setQy_id(Auth.getQiye(msg).getId());
                ids.append(moduleDao.findlistById(module).getId());
                if (i != split.length - 1) {
                    ids.append(",");
                }
            }
            Bumen bumen = new Bumen();
            bumen.setFjqx(ids.toString());

            return bumen;
        } else {
            return new Bumen();
        }

    }

    @Override
    public Msg add(Module module, HttpSession session) {
        User user = (User) session.getAttribute(Cons.user);
        System.err.println("module====>" + module);
        if (Str.isAnyEmpty(module.getId())) {
            module.setQy_id(user.getQy_id());
            module.setId(ID.getID());
            moduleDao.add(module);
            return new Msg("添加成功", Cons.add);
        } else {
            moduleDao.modify(module);
            return new Msg("修改成功", Cons.modify);
        }
    }

    @Override
    public Msg remove(Module module, HttpSession session) {
        if (Str.isNotAnyEmpty(module.getId())) {
            moduleDao.remove(module);
            return new Msg("删除模块" + module.getName() + "成功", 0);
        } else {
            return new Msg("删除失败", -1);
        }

    }
}
