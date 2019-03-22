package com.westos.Information.service.impl.dataIndex;

import com.westos.Information.bean.Module;
import com.westos.Information.bean.Msg;
import com.westos.Information.dao.ModuleDao;
import com.westos.Information.service.service.dataIndex.DataIndexService;
import com.westos.Information.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return moduleDao.findUserModule(Auth.getUser(msg));
    }
}
