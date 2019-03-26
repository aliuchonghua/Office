package com.westos.Information.service.service.grzx;

import com.westos.Information.bean.Msg;
import com.westos.Information.bean.User;
import com.westos.Information.bean.Validator;

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
    /**
     * 密码验证
     */
    Validator verification(Msg msg);
}
