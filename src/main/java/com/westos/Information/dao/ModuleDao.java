package com.westos.Information.dao;

import com.westos.Information.bean.Module;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ModuleDao {
    /**
     * 主列表加载
     * @param module 带有模块类型
     * @return
     */
    List<Module> findlist(Module module);

    /**
     * 添加
     */
    Integer add(Module module);
    /**
     * 修改
     */
    Integer modify(Module module);
    /**
     * 删除
     */
    Integer remove(Module module);

}
