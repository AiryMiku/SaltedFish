package com.airy.saltedfish.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Airy on 2017/11/13
 */

@Entity
public class Message {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @NotBlank(message = "必传")
    private String content;

    private Integer likeNum;
    private Integer disLikeNum;

    @OneToMany
    @JoinColumn(name = "messageId")
    private List<Comment> comments;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Message(){
        comments = new ArrayList<>();
    }

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

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getDisLikeNum() {
        return disLikeNum;
    }

    public void setDisLikeNum(Integer disLikeNum) {
        this.disLikeNum = disLikeNum;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
