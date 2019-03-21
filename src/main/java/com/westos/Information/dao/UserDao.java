package com.westos.Information.dao;

import com.westos.Information.bean.Bumen;
import com.westos.Information.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserDao {
    /**
     * 加载用户列表
     */
    List<User> findList(Bumen bumen);
    //查找账户是否存在
    User findsjhToUser(User user);
    //手机号查重复
    User findRepeatBySjh(User user);
    //通过手机号，密码获取用户
    User sjhAndPassToUser(User user);
    //添加用户
    Integer addUser(User user);
    //通过id修改用户
    Integer modifyUser(User user);
    //通过id删除用户
    Integer deleteUser(User user);

}
