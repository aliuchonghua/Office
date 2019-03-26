package com.westos.Information.bean;


import java.util.Date;
import java.util.Objects;

public class Gonggao {

  private String id;
  private String bt;//标题
  private String nr;//内容
  private String u_id;//用户id
  private Date cjsj;//创建时间
  private String u_name;//用户名
  private String qy_id;//企业id

  @Override
  public String toString() {
    return "Gonggao{" +
            "id='" + id + '\'' +
            ", bt='" + bt + '\'' +
            ", nr='" + nr + '\'' +
            ", u_id='" + u_id + '\'' +
            ", cjsj=" + cjsj +
            ", u_name='" + u_name + '\'' +
            ", qy_id='" + qy_id + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Gonggao gonggao = (Gonggao) o;
    return Objects.equals(id, gonggao.id) &&
            Objects.equals(bt, gonggao.bt) &&
            Objects.equals(nr, gonggao.nr) &&
            Objects.equals(u_id, gonggao.u_id) &&
            Objects.equals(cjsj, gonggao.cjsj) &&
            Objects.equals(u_name, gonggao.u_name) &&
            Objects.equals(qy_id, gonggao.qy_id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, bt, nr, u_id, cjsj, u_name, qy_id);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBt() {
    return bt;
  }

  public void setBt(String bt) {
    this.bt = bt;
  }

  public String getNr() {
    return nr;
  }

  public void setNr(String nr) {
    this.nr = nr;
  }

  public String getU_id() {
    return u_id;
  }

  public void setU_id(String u_id) {
    this.u_id = u_id;
  }

  public Date getCjsj() {
    return cjsj;
  }

  public void setCjsj(Date cjsj) {
    this.cjsj = cjsj;
  }

  public String getU_name() {
    return u_name;
  }

  public void setU_name(String u_name) {
    this.u_name = u_name;
  }

  public String getQy_id() {
    return qy_id;
  }

  public void setQy_id(String qy_id) {
    this.qy_id = qy_id;
  }
}
