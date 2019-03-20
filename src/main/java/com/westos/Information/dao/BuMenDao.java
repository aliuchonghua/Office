package com.westos.Information.dao;

import com.westos.Information.bean.Bumen;
import com.westos.Information.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuMenDao {
    /**
     * 主列表加载
     */
    List<Bumen>findlist(User user);
    /**
     * 查找
     */
    Bumen findName(Bumen bumen);
    /**
     * 新增
     */
    Integer add(Bumen bumen);
    /**
     * 修改
     */
    Integer modify(Bumen bumen);
    /**
     * 删除
     */
    Integer remove(Bumen bumen);
}
