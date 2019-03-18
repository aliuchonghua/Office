package com.westos.Information.service.service.dataIndex;

import com.westos.Information.bean.Module;
import com.westos.Information.bean.Msg;

import java.util.List;

public interface DataIndexService {
    /**
     * 获取当前用户全部的模块
     */
    List<Module> loadModel(Msg msg);
}
