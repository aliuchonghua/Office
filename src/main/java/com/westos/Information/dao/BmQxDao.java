package com.westos.Information.dao;

import com.westos.Information.bean.BmQx;
import com.westos.Information.bean.Bumen;

public interface BmQxDao {
    /**
     * 保存
     */
    Integer save(BmQx bmQx);
    /**
     * 删除
     */
    Integer delete(Bumen bumen);
}
