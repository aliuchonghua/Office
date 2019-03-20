package com.westos.Information.bean;


import java.util.Date;
import java.util.Objects;

public class User {
    private String id;
    private String sjh;            //手机号
    private String name;        //姓名
    private Date csny;        //出生年月
    private String xb;            //性别
    private Integer zhlx;        //账户类型0(管理员)1(领导)2(部门负责人)3(员工)
    private Integer zhlx_name;    //账户类型名称
    private String dq;            //地区
    private String qy_id;        //企业id
    private String qy_name;        //企业名
    private Integer bm_id;        //部门id
    private String bm_name;        //部门名
    private String pass;        //密码

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", sjh='" + sjh + '\'' +
                ", name='" + name + '\'' +
                ", csny=" + csny +
                ", xb='" + xb + '\'' +
                ", zhlx=" + zhlx +
                ", zhlx_name=" + zhlx_name +
                ", dq='" + dq + '\'' +
                ", qy_id='" + qy_id + '\'' +
                ", qy_name='" + qy_name + '\'' +
                ", bm_id=" + bm_id +
                ", bm_name='" + bm_name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(sjh, user.sjh) &&
                Objects.equals(name, user.name) &&
                Objects.equals(csny, user.csny) &&
                Objects.equals(xb, user.xb) &&
                Objects.equals(zhlx, user.zhlx) &&
                Objects.equals(zhlx_name, user.zhlx_name) &&
                Objects.equals(dq, user.dq) &&
                Objects.equals(qy_id, user.qy_id) &&
                Objects.equals(qy_name, user.qy_name) &&
                Objects.equals(bm_id, user.bm_id) &&
                Objects.equals(bm_name, user.bm_name) &&
                Objects.equals(pass, user.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sjh, name, csny, xb, zhlx, zhlx_name, dq, qy_id, qy_name, bm_id, bm_name, pass);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSjh() {
        return sjh;
    }

    public void setSjh(String sjh) {
        this.sjh = sjh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCsny() {
        return csny;
    }

    public void setCsny(Date csny) {
        this.csny = csny;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public Integer getZhlx() {
        return zhlx;
    }

    public void setZhlx(Integer zhlx) {
        this.zhlx = zhlx;
    }

    public Integer getZhlx_name() {
        return zhlx_name;
    }

    public void setZhlx_name(Integer zhlx_name) {
        this.zhlx_name = zhlx_name;
    }

    public String getDq() {
        return dq;
    }

    public void setDq(String dq) {
        this.dq = dq;
    }

    public String getQy_id() {
        return qy_id;
    }

    public void setQy_id(String qy_id) {
        this.qy_id = qy_id;
    }

    public String getQy_name() {
        return qy_name;
    }

    public void setQy_name(String qy_name) {
        this.qy_name = qy_name;
    }

    public Integer getBm_id() {
        return bm_id;
    }

    public void setBm_id(Integer bm_id) {
        this.bm_id = bm_id;
    }

    public String getBm_name() {
        return bm_name;
    }

    public void setBm_name(String bm_name) {
        this.bm_name = bm_name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
