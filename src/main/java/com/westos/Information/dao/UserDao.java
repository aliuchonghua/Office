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
    //通过id查用户
    User findUserById(User user);
    //添加用户
    Integer addUser(User user);
    //通过id修改用户
    Integer modifyUser(User user);
    //通过id删除用户
    Integer deleteUser(User user);
    /**
     * 查找上级部门负责人
     */
    List<User> findLeader(User user);

    /**
     * 查找领导
     */
    List<User> findBoss(User user);
    /**
     * 查找部门负责人
     */
    List<User> findBmfzr(User user);
    /**
     * 查找下属员工
     */
    List<User> findYg(User user);

    /**
     * 员工任务绩效
     */
    List<User> ygrwjx(User user);
    /**
     * 个人任务绩效
     */
    List<User> grrwjx(User user);

}
