package com.airy.saltedfish.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.DateTimeException;
import java.util.Date;

/**
 * Created by Airy on 2017/11/13
 */
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Integer id;

    private String nickName;
    private String Cotent;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCotent() {
        return Cotent;
    }

    public void setCotent(String cotent) {
        Cotent = cotent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", Cotent='" + Cotent + '\'' +
                ", date=" + date +
                '}';
    }
}
