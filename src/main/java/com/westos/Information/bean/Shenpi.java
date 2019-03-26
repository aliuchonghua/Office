package com.westos.Information.bean;


import java.util.Date;
import java.util.Objects;

public class Shenpi {

  private String id;
  private String splx;//审批类型
  private String u_id;//发起人
  private String u_name;
  private String spr_id;//审批人
  private String spr_name;
  private Date fqsj;//发起时间
  private String start_time;//开始时间
  private String end_time;//结束时间
  private String type;//审批状态
  private String yy;//原因
  private String cfcs;//出发城市
  private String mdcs;//目的城市
  private String jtgj;//交通工具
  private String qy_id;//企业
  private String bm_id;//部门

  @Override
  public String toString() {
    return "Shenpi{" +
            "id='" + id + '\'' +
            ", splx='" + splx + '\'' +
            ", u_id='" + u_id + '\'' +
            ", u_name='" + u_name + '\'' +
            ", spr_id='" + spr_id + '\'' +
            ", spr_name='" + spr_name + '\'' +
            ", fqsj=" + fqsj +
            ", start_time='" + start_time + '\'' +
            ", end_time='" + end_time + '\'' +
            ", type='" + type + '\'' +
            ", yy='" + yy + '\'' +
            ", cfcs='" + cfcs + '\'' +
            ", mdcs='" + mdcs + '\'' +
            ", jtgj='" + jtgj + '\'' +
            ", qy_id='" + qy_id + '\'' +
            ", bm_id='" + bm_id + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Shenpi shenpi = (Shenpi) o;
    return Objects.equals(id, shenpi.id) &&
            Objects.equals(splx, shenpi.splx) &&
            Objects.equals(u_id, shenpi.u_id) &&
            Objects.equals(u_name, shenpi.u_name) &&
            Objects.equals(spr_id, shenpi.spr_id) &&
            Objects.equals(spr_name, shenpi.spr_name) &&
            Objects.equals(fqsj, shenpi.fqsj) &&
            Objects.equals(start_time, shenpi.start_time) &&
            Objects.equals(end_time, shenpi.end_time) &&
            Objects.equals(type, shenpi.type) &&
            Objects.equals(yy, shenpi.yy) &&
            Objects.equals(cfcs, shenpi.cfcs) &&
            Objects.equals(mdcs, shenpi.mdcs) &&
            Objects.equals(jtgj, shenpi.jtgj) &&
            Objects.equals(qy_id, shenpi.qy_id) &&
            Objects.equals(bm_id, shenpi.bm_id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, splx, u_id, u_name, spr_id, spr_name, fqsj, start_time, end_time, type, yy, cfcs, mdcs, jtgj, qy_id, bm_id);
  }

  public Date getFqsj() {
    return fqsj;
  }

  public void setFqsj(Date fqsj) {
    this.fqsj = fqsj;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSplx() {
    return splx;
  }

  public void setSplx(String splx) {
    this.splx = splx;
  }

  public String getU_id() {
    return u_id;
  }

  public void setU_id(String u_id) {
    this.u_id = u_id;
  }

  public String getU_name() {
    return u_name;
  }

  public void setU_name(String u_name) {
    this.u_name = u_name;
  }

  public String getSpr_id() {
    return spr_id;
  }

  public void setSpr_id(String spr_id) {
    this.spr_id = spr_id;
  }

  public String getSpr_name() {
    return spr_name;
  }

  public void setSpr_name(String spr_name) {
    this.spr_name = spr_name;
  }

  public String getStart_time() {
    return start_time;
  }

  public void setStart_time(String start_time) {
    this.start_time = start_time;
  }

  public String getEnd_time() {
    return end_time;
  }

  public void setEnd_time(String end_time) {
    this.end_time = end_time;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getYy() {
    return yy;
  }

  public void setYy(String yy) {
    this.yy = yy;
  }

  public String getCfcs() {
    return cfcs;
  }

  public void setCfcs(String cfcs) {
    this.cfcs = cfcs;
  }

  public String getMdcs() {
    return mdcs;
  }

  public void setMdcs(String mdcs) {
    this.mdcs = mdcs;
  }

  public String getJtgj() {
    return jtgj;
  }

  public void setJtgj(String jtgj) {
    this.jtgj = jtgj;
  }

  public String getQy_id() {
    return qy_id;
  }

  public void setQy_id(String qy_id) {
    this.qy_id = qy_id;
  }

  public String getBm_id() {
    return bm_id;
  }

  public void setBm_id(String bm_id) {
    this.bm_id = bm_id;
  }
}
