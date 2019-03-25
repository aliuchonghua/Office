package com.westos.Information.service.service.zzjg;

import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Qiye;
import com.westos.Information.bean.User;

import java.util.List;

/**
 * 企业管理
 */
public interface QyService {
    /**
     * 主列表加载
     */
    Qiye find(Msg msg);
    /**
     * 修改
     */
    Msg modify(Msg msg);
    /**
     * 注销企业
     */
    Msg logout(Msg msg);

}
