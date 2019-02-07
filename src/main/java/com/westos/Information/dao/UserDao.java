package com.westos.Information.dao;

import com.westos.Information.bean.User;

import java.util.List;

public interface UserDao {
    //通过手机号获取用户
    User sjhToUser(User user);
    //通过手机号，密码获取用户
    User sjhAndPassToUser(User user);
    //通过id获取用户
    User idToUser(User user);
    //分页获取所有用户
    List<User> PaginationUserAll(User user);
    //添加用户
    Integer addUser(User user);
    //通过id修改用户
    Integer modifyUser(User user);
    //通过id删除用户
    Integer deleteUser(User user);

}