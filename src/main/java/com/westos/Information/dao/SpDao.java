package com.westos.Information.dao;

import com.westos.Information.bean.Shenpi;
import com.westos.Information.bean.User;
import com.westos.Information.bean.WorkSpzl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 审批
 */
@Mapper
public interface SpDao {
    /**
     * 查看我发起的审批
     *
     * @param shenpi 包含u_id type(待审批,已通过,未通过)
     */
    List<Shenpi> findMyWFQ(Shenpi shenpi);

    /**
     * 查看我审批的
     *
     * @param shenpi 包含 spr_id type
     * @return
     */
    List<Shenpi> findMyWsp(Shenpi shenpi);

    /**
     * 新增
     *
     * @param shenpi
     * @return
     */
    Integer add(Shenpi shenpi);

    /**
     * 删除
     *
     * @param shenpi
     * @return
     */
    Integer remove(Shenpi shenpi);

    /**
     * 审批
     */
    Integer update(Shenpi shenpi);

    /**
     * 个人审批类型
     */
    WorkSpzl grspzl(User user);


}
