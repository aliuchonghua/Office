package com.westos.Information.bean;

import java.util.Date;
import java.util.Objects;

public class qiye {
    private Integer id;
    private String name;	//企业名称
    private String hymc;	//行业名称
    private Integer gly_id;	//管理员id
    private Date clrq;	//成立日期
    private String dq;		//地区
    private String xxdz;	//详细地址
    private String zczj;	//注册资金
    private String jyfw;	//经营范围
    private String qyjj;	//企业简介

    @Override
    public String toString() {
        return "qiye{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hymc='" + hymc + '\'' +
                ", gly_id=" + gly_id +
                ", clrq=" + clrq +
                ", dq='" + dq + '\'' +
                ", xxdz='" + xxdz + '\'' +
                ", zczj='" + zczj + '\'' +
                ", jyfw='" + jyfw + '\'' +
                ", qyjj='" + qyjj + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        qiye qiye = (qiye) o;
        return Objects.equals(id, qiye.id) &&
                Objects.equals(name, qiye.name) &&
                Objects.equals(hymc, qiye.hymc) &&
                Objects.equals(gly_id, qiye.gly_id) &&
                Objects.equals(clrq, qiye.clrq) &&
                Objects.equals(dq, qiye.dq) &&
                Objects.equals(xxdz, qiye.xxdz) &&
                Objects.equals(zczj, qiye.zczj) &&
                Objects.equals(jyfw, qiye.jyfw) &&
                Objects.equals(qyjj, qiye.qyjj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, hymc, gly_id, clrq, dq, xxdz, zczj, jyfw, qyjj);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHymc() {
        return hymc;
    }

    public void setHymc(String hymc) {
        this.hymc = hymc;
    }

    public Integer getGly_id() {
        return gly_id;
    }

    public void setGly_id(Integer gly_id) {
        this.gly_id = gly_id;
    }

    public Date getClrq() {
        return clrq;
    }

    public void setClrq(Date clrq) {
        this.clrq = clrq;
    }

    public String getDq() {
        return dq;
    }

    public void setDq(String dq) {
        this.dq = dq;
    }

    public String getXxdz() {
        return xxdz;
    }

    public void setXxdz(String xxdz) {
        this.xxdz = xxdz;
    }

    public String getZczj() {
        return zczj;
    }

    public void setZczj(String zczj) {
        this.zczj = zczj;
    }

    public String getJyfw() {
        return jyfw;
    }

    public void setJyfw(String jyfw) {
        this.jyfw = jyfw;
    }

    public String getQyjj() {
        return qyjj;
    }

    public void setQyjj(String qyjj) {
        this.qyjj = qyjj;
    }
}
