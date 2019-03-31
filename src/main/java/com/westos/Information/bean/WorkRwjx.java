package com.westos.Information.bean;

import java.util.List;

public class WorkRwjx {
    List name;
    List wks;//未开始
    List jxz;//进行中
    List ywc;//已完成

    public WorkRwjx(List name, List wks, List jxz, List ywc) {
        this.name = name;
        this.wks = wks;
        this.jxz = jxz;
        this.ywc = ywc;
    }
    public WorkRwjx() {
    }

    public List getName() {
        return name;
    }

    public void setName(List name) {
        this.name = name;
    }

    public List getWks() {
        return wks;
    }

    public void setWks(List wks) {
        this.wks = wks;
    }

    public List getJxz() {
        return jxz;
    }

    public void setJxz(List jxz) {
        this.jxz = jxz;
    }

    public List getYwc() {
        return ywc;
    }

    public void setYwc(List ywc) {
        this.ywc = ywc;
    }
}
