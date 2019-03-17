package com.westos.Information.bean;

import java.util.Objects;

public class Module {
    private String id;
    private String name;
    private String code;
    private String link;
    private String zhlx;
    private String mdlx;
    private String qy_id;

    @Override
    public String toString() {
        return "Module{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", link='" + link + '\'' +
                ", zhlx='" + zhlx + '\'' +
                ", mdlx='" + mdlx + '\'' +
                ", qy_id='" + qy_id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return Objects.equals(id, module.id) &&
                Objects.equals(name, module.name) &&
                Objects.equals(code, module.code) &&
                Objects.equals(link, module.link) &&
                Objects.equals(zhlx, module.zhlx) &&
                Objects.equals(mdlx, module.mdlx) &&
                Objects.equals(qy_id, module.qy_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, link, zhlx, mdlx, qy_id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getZhlx() {
        return zhlx;
    }

    public void setZhlx(String zhlx) {
        this.zhlx = zhlx;
    }

    public String getMdlx() {
        return mdlx;
    }

    public void setMdlx(String mdlx) {
        this.mdlx = mdlx;
    }

    public String getQy_id() {
        return qy_id;
    }

    public void setQy_id(String qy_id) {
        this.qy_id = qy_id;
    }
}
