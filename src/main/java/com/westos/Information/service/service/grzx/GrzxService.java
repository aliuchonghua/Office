package com.westos.Information.service.service.grzx;

import com.westos.Information.bean.Msg;
import com.westos.Information.bean.User;

/**
 * 个人中心
 */
public interface GrzxService {
    /**
     * 个人信息
     */
    User find(Msg msg);
    /**
     * 修改密码
     */
    Msg modify(Msg msg);
}
