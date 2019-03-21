package com.westos.Information.controller;

import com.westos.Information.bean.City;
import com.westos.Information.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    //返回省份
    @RequestMapping(value = "/sheng", method = RequestMethod.GET)
    public List<City> getSheng() {
        return cityService.getSheng();
    }
    //返回省份
    @RequestMapping(value = "/getShengByName", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public City getSheng(@RequestBody City city) {
        return cityService.getShengByName(city);
    }

    //返回城市
    @RequestMapping(value = "/shi", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<City> getshi(@RequestBody City city) {
        return cityService.getShi(city);

    }
    //返回城市
    @RequestMapping(value = "/getshiByName", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public City getshiByName(@RequestBody City city) {
        return cityService.getshiByName(city);

    }
    //返回县
    @RequestMapping(value = "/xian", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<City> getxian(@RequestBody City city) {
        return cityService.getXian(city);
    }

}
