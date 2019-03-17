package com.westos.Information.service.service.mkgl;

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
     * 添加
     */
    Msg add(Module module, HttpSession session);

    /**
     * 删除
     */
    Msg remove(Module module, HttpSession session);

}
