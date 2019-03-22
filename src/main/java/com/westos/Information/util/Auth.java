package com.westos.Information.util;

import com.westos.Information.bean.Msg;
import com.westos.Information.bean.Qiye;
import com.westos.Information.bean.User;

/**
 * @author liuchonghua
 */
public class Auth {
    /**
     * 获取用户
     */
    public static User getUser(Msg msg){
        return (User) msg.getSession().getAttribute(Cons.user);
    }

    /**
     * 获取企业
     */
    public static Qiye getQiye(Msg msg){
        return (Qiye) msg.getSession().getAttribute(Cons.qiye);
    }
}
