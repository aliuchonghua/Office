package com.westos.Information.bean;


import java.util.Objects;

public class GgWeidu {

  private String id;
  private String g_id;
  private String u_id;

  @Override
  public String toString() {
    return "GgWeidu{" +
            "id='" + id + '\'' +
            ", g_id='" + g_id + '\'' +
            ", u_id='" + u_id + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GgWeidu ggWeidu = (GgWeidu) o;
    return Objects.equals(id, ggWeidu.id) &&
            Objects.equals(g_id, ggWeidu.g_id) &&
            Objects.equals(u_id, ggWeidu.u_id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, g_id, u_id);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getG_id() {
    return g_id;
  }

  public void setG_id(String g_id) {
    this.g_id = g_id;
  }

  public String getU_id() {
    return u_id;
  }

  public void setU_id(String u_id) {
    this.u_id = u_id;
  }
}
