package com.westos.Information.service.service.gg;

import com.westos.Information.bean.Gonggao;
import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Qiye;

import java.util.List;

/**
 *公告管理
 */
public interface GgService {
    /**
     * 已读列表加载
     */
    List<Gonggao> findYdList(Msg msg);
    /**
     * 未读列表加载
     */
    List<Gonggao> findWdList(Msg msg);
    /**
     * 自己发出的
     */
    List<Gonggao> findZjList(Msg msg);
    /**
     * 新增
     */
    Msg add(Msg msg);
    /**
     * 设置已读
     */
    Msg haveRead(Msg msg);
    /**
     * 删除
     */
    Msg delete(Msg msg);


}
