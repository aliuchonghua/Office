package com.westos.Information.dao;

import com.westos.Information.bean.Qiye;
import com.westos.Information.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QiyeDao {
    //创建企业
    Integer addQiye(Qiye qiye);
    //修改企业
    Integer modifyQiye(Qiye qiye);
    //查找同名企业
    Qiye findNameToQiye(Qiye qiye);
    //根据id查企业
    Qiye findQiyeById(User user);
    //注销企业
    Integer emptyFirm(Qiye qiye);

}
