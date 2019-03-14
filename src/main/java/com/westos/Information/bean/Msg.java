package com.westos.Information.bean;

import javax.servlet.http.HttpSession;

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


    public Msg() {
    }

    public Msg(String mess) {
        this.mess = mess;
    }

    public Msg(String mess, Integer type) {
        this.mess = mess;
        this.type = type;
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


}
