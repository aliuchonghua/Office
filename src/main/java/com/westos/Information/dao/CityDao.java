package com.westos.Information.dao;

import com.westos.Information.bean.City;

import java.util.List;

public interface CityDao {
    //获取省份
    List<String> getSheng();
    //获取市
    List<String> getShi(City city);
    //获取县
    List<String> getXian(City city);
}
