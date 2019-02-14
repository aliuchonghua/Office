package com.westos.Information.bean;

import javax.servlet.http.HttpSession;

/**
 * 消息
 */
public class Msg {
    private String mess;
    private String html;
    private Qiye qiye;
    private User user;
    private Integer Type;
    private HttpSession session;


    public Msg() {
    }

    public Msg(String mess) {
        this.mess = mess;
    }

    public Msg(String mess, Integer type) {
        this.mess = mess;
        Type = type;
    }

    public Integer getType() {
        return Type;
    }

    public void setType(Integer type) {
        Type = type;
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
