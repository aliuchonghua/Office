package com.westos.Information.bean;


public class BmQx {

  private String id;
  private String bm_id;
  private String md_id;

    public BmQx(String id, String bm_id, String md_id) {
        this.id = id;
        this.bm_id = bm_id;
        this.md_id = md_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBm_id() {
        return bm_id;
    }

    public void setBm_id(String bm_id) {
        this.bm_id = bm_id;
    }

    public String getMd_id() {
        return md_id;
    }

    public void setMd_id(String md_id) {
        this.md_id = md_id;
    }
}
