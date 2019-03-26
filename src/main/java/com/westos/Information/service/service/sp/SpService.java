package com.westos.Information.service.service.sp;

import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Shenpi;
import com.westos.Information.bean.User;

import java.util.List;

/**
 *审批管理
 */
public interface SpService {
    /**
     * 我发起的
     */
    List<Shenpi>findMyWFQ(Msg msg);
    /**
     * 我审批的
     */
    List<Shenpi>findMyWsp(Msg msg);
    /**
     * 新增
     */
    Msg add(Msg msg);
    /**
     * 删除
     */
    Msg remove(Msg msg);
    /**
     * 查询上级领导
     */
    List<User> findleader(Msg msg);
    /**
     * 审批
     */
    Msg update(Msg msg);




}
