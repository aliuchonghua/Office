package com.westos.Information.service.service.zzjg;

import com.westos.Information.bean.Bumen;
import com.westos.Information.bean.Msg;
import com.westos.Information.bean.User;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 人员管理
 */
public interface RyService {
    /**
     * 主列表加载
     */
    List<User>findlist(Msg msg);
    /**
     * 新增
     */
    Msg add(Msg msg);
    /**
     * 修改
     */
    Msg modify(Msg msg);
    /**
     * 删除
     */
    Msg remove(Msg msg);

}
