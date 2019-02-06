package com.westos.Information.service;

import com.westos.Information.bean.City;

import java.util.List;

public interface CityService {

    //获取省份
    List<String> getSheng();

    //    获取城市
    List<String> getShi(City city);

    //获取区县
    List<String> getXian(City city);

}
