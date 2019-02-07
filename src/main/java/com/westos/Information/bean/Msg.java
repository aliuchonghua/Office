package com.westos.Information.bean;

/**
 * 消息
 */
public class Msg {
    private String mess;
    private String html;
    private Qiye qiye;
    private User user;

    private Msg() {
    }

    public Msg(String mess) {
        this.mess = mess;
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

}
