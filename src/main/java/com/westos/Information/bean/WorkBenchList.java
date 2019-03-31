package com.westos.Information.bean;

import java.util.List;

public class WorkBenchList {
    private List name;//名字
    private List value;//数量
    private List<WorkBench> wbmap;

    public WorkBenchList() {

    }

    public WorkBenchList(List name, List value) {
        this.name = name;
        this.value = value;
    }

    public List getName() {
        return name;
    }

    public void setName(List name) {
        this.name = name;
    }

    public List getValue() {
        return value;
    }

    public void setValue(List value) {
        this.value = value;
    }

    public List<WorkBench> getWbmap() {
        return wbmap;
    }

    public void setWbmap(List<WorkBench> wbmap) {
        this.wbmap = wbmap;
    }
}
