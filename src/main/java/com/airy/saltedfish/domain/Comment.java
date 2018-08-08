package com.airy.saltedfish.domain;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

/**
 * Created by Airy on 2017/11/13
 */
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Integer id;

    private String content;
    private Date date;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}
