package com.westos.Information.dao;

import com.westos.Information.bean.Module;
import com.westos.Information.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ModuleDao {
    /**
     * 主列表加载
     *
     * @param module 带有模块类型
     * @return
     */
    List<Module> findlist(Module module);

    /**
     * 获取当前企业部门可选的附加模块
     */
    List<Module> findModuleByQiye(User user);

    /**
     * 根据name串获取模块
     */
    Module findlistById(Module module);

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

    /**
     * 查找当前用户的模块
     */
    List<Module> findUserModule(User user);

}
