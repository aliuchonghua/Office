package com.westos.Information.bean;


import java.util.Objects;

public class Bumen {

  private String id;
  private String qy_id;
  private String name;
  private String fjqx;//附加权限

    public String getFjqx() {
        return fjqx;
    }

    public void setFjqx(String fjqx) {
        this.fjqx = fjqx;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQy_id() {
        return qy_id;
    }

    public void setQy_id(String qy_id) {
        this.qy_id = qy_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bumen{" +
                "id='" + id + '\'' +
                ", qy_id='" + qy_id + '\'' +
                ", name='" + name + '\'' +
                ", fjqx='" + fjqx + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bumen bumen = (Bumen) o;
        return Objects.equals(id, bumen.id) &&
                Objects.equals(qy_id, bumen.qy_id) &&
                Objects.equals(name, bumen.name) &&
                Objects.equals(fjqx, bumen.fjqx);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qy_id, name, fjqx);
    }
}
