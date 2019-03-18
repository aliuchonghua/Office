package com.westos.Information.service.impl.dataIndex;

import com.westos.Information.bean.Module;
import com.westos.Information.bean.Msg;
import com.westos.Information.bean.User;
import com.westos.Information.dao.ModuleDao;
import com.westos.Information.service.service.dataIndex.DataIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class DataIndexImpl implements DataIndexService {
    @Autowired
    private ModuleDao moduleDao;

    /**
     * 查找当前用户的模块
     */
    @Override
    public List<Module> loadModel(Msg msg) {
        HttpSession session = msg.getSession();
        User user = (User) session.getAttribute("Auth_user");
        return moduleDao.findUserModule(user);
    }
}
