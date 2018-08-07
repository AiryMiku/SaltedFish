package com.airy.saltedfish.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Airy on 2018/6/28
 */
@Entity
public class Page {
    @Id
    @GeneratedValue
    private Integer Id;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    private String content;

//    private List<Image> niceImage;

    @OneToMany
    @JoinColumn(name = "messageId")
    private Set<Comment> comments = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "blockId")
    private Block block;

    private String publishDate;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
