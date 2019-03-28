package com.westos.Information.dao;

import com.westos.Information.bean.Renwu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 任务
 */
@Mapper
public interface RwDao {
    /**
     * 查看我的任务
     * @param renwu 包含zx_id和type 未开始,进行中,已完成
     * @return
     */
    List<Renwu> findMyRw(Renwu renwu);

    /**
     * 查看我下发的任务
     * @param renwu 包含 u_id和type
     * @return
     */
    List<Renwu>findWXF(Renwu renwu);
    /**
     * 创建任务
     */
    Integer add(Renwu renwu);
    /**
     * 修改
     */
    Integer modify(Renwu renwu);
    /**
     * 撤销
     */
    Integer delete(Renwu renwu);

            
}
