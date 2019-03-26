package com.westos.Information.dao;

import com.westos.Information.bean.GgWeidu;
import com.westos.Information.bean.Gonggao;
import com.westos.Information.bean.Qiye;
import com.westos.Information.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GgDao {
    /**
     * 未读列表加载
     * @param user 当前登陆用户
     */
    List<Gonggao>findWdList(User user);
    /**
     * 已读列表加载
     * @param user 当前登陆用户
     */
    List<Gonggao>findYdList(User user);
    /**
     * 自己发出的公告
     * @param user 当前登陆用户
     */
    List<Gonggao>findZjList(User user);

    /**
     * 新增
     */
    Integer add(Gonggao gonggao);

    /**
     * 设置已读
     */
    Integer haveRead(GgWeidu ggWeidu);
    //删除
    Integer delete(Gonggao gonggao);
}
