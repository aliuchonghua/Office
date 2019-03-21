package com.westos.Information.service;

import com.westos.Information.bean.City;
import com.westos.Information.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CityServiceimpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public List<City> getSheng() {
        return cityDao.getSheng();
    }
    @Override
    public City getShengByName(City city) {
        return cityDao.getShengByName(city);
    }


    @Override
    public List<City> getShi(City city) {
        return cityDao.getShi(city);
    }

    @Override
    public City getshiByName(City city) {
        return cityDao.getshiByName(city);
    }

    @Override
    public List<City> getXian(City city) {
        return cityDao.getXian(city);
    }
}
