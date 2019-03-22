package com.westos.Information.service.service.zzjg;

import com.westos.Information.bean.Bumen;
import com.westos.Information.bean.Msg;

import java.util.List;

public interface BmService {
    /**
     * 主列表加载
     */
    List<Bumen> findlist(Msg msg);
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
