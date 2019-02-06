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
    public List<String> getSheng() {
        return cityDao.getSheng();
    }

    @Override
    public List<String> getShi(City city) {
        return cityDao.getShi(city);
    }

    @Override
    public List<String> getXian(City city) {
        return cityDao.getXian(city);
    }
}
