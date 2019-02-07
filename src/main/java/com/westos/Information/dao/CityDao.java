package com.westos.Information.dao;

import com.westos.Information.bean.City;

import java.util.List;

public interface CityDao {
    //获取省份
    List<City> getSheng();
    //获取市
    List<City> getShi(City city);
    //获取县
    List<City> getXian(City city);
}
