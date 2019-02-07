package com.westos.Information.bean;

import java.util.Objects;

public class City {

    private Integer id;
    private Integer pid;
    private String cityname;
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", pid=" + pid +
                ", cityname='" + cityname + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) &&
                Objects.equals(pid, city.pid) &&
                Objects.equals(cityname, city.cityname) &&
                Objects.equals(type, city.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pid, cityname, type);
    }
}
