package com.westos.Information.service;

import com.westos.Information.bean.City;

import java.util.List;

public interface CityService {

    //获取省份
    List<City> getSheng();

    //    获取城市
    List<City> getShi(City city);

    //获取区县
    List<City> getXian(City city);

}
