package com.westos.Information.service.service.mkgl;

import com.westos.Information.bean.Bumen;
import com.westos.Information.bean.Module;
import com.westos.Information.bean.Msg;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface MkglService {
    /**
     * 主列表加载
     * @param module
     * @return
     */
    List<Module> findlist(Module module, HttpSession session);
    /**
     * 获取当前企业部门可选的附加模块
     */
    List<Module> findMk(Msg msg);
    /**
     * 根据名称串获取id串
     */
    Bumen fingModuleByname(Msg msg);

    /**
     * 添加
     */
    Msg add(Module module, HttpSession session);

    /**
     * 删除
     */
    Msg remove(Module module, HttpSession session);

}
