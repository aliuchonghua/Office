package com.westos.Information.service;

import com.westos.Information.bean.User;

/**
 * 注册相关
 */
public interface RegisteredService {
    //验证账户是否存在
    String testSjh(User user);
}
