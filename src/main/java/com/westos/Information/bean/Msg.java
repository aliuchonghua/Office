package com.westos.Information.bean;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 消息
 */
public class Msg {
    private String mess;//消息
    private String html;//链接
    private Qiye qiye;
    private User user;
    private Integer type;//状态码
    private HttpSession session;
    private Module module;//模块
    private Bumen bumen;
    private String valid;//表单验证
    private Gonggao gonggao;//公告

    public Msg(HttpSession session, Gonggao gonggao) {
        this.session = session;
        this.gonggao = gonggao;
    }

    public Msg(HttpSession session, Qiye qiye) {
        this.qiye = qiye;
        this.session = session;
    }

    public Msg(HttpSession session, User user) {
        this.user = user;
        this.session = session;
    }

    public Msg(HttpSession session, Bumen bumen) {
        this.session = session;
        this.bumen = bumen;
    }

    public Msg(String mess, Integer type) {
        this.mess = mess;
        this.type = type;
    }

    public Gonggao getGonggao() {
        return gonggao;
    }

    public void setGonggao(Gonggao gonggao) {
        this.gonggao = gonggao;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }


    public Bumen getBumen() {
        return bumen;
    }

    public void setBumen(Bumen bumen) {
        this.bumen = bumen;
    }

    public Msg() {
    }

    public Msg(HttpSession session) {
        this.session = session;
    }

    public Msg(String mess) {
        this.mess = mess;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Qiye getQiye() {
        return qiye;
    }

    public void setQiye(Qiye qiye) {
        this.qiye = qiye;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
