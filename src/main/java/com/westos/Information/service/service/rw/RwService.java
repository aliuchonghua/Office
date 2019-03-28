package com.westos.Information.service.service.rw;

import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Renwu;
import com.westos.Information.bean.Shenpi;
import com.westos.Information.bean.User;

import java.util.List;

/**
 *任务管理
 */
public interface RwService {
    /**
     * 我的任务
     */
    List<Renwu> findMyRw(Msg msg);
    /**
     * 我下发的
     */
    List<Renwu>findWXF(Msg msg);
    /**
     * 查询下属员工
     */
    List<User>findXs(Msg msg);
    /**
     * 创建任务
     */
    Msg add(Msg msg);
    /**
     * 修改任务状态
     */
    Msg modify(Msg msg);
    /**
     * 撤销下发的任务
     */
    Msg delete(Msg msg);




}
